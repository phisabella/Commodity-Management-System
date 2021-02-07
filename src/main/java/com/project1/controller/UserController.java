package com.project1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project1.entity.Goods;
import com.project1.entity.Levellink;
import com.project1.entity.Permission;
import com.project1.entity.User;
import com.project1.mapper.LevelLinkMapper;
import com.project1.mapper.PermissionMapper;
import com.project1.mapper.UserMapper;
import com.project1.service.UserService;
import com.project1.utils.Respone;
import com.project1.utils.ValidateImageCodeUtils;
import com.project1.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private LevelLinkMapper levelLinkMapper;
    //登陆方法
    @GetMapping("/login")
    public String login(String username, String password, String code, HttpSession session){
        User login = userService.login(username, password);
        String sessioncode = (String) session.getAttribute("code");

        if(login!=null && sessioncode.equalsIgnoreCase(code)){
            User user = userMapper.selectById(login.getId());
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("level",user.getLevel());
            Permission level = permissionMapper.selectOne(wrapper);
            session.setAttribute("user",user);
            session.setAttribute("level",level);
            return "redirect:/indexx";
        }else{
            return "redirect:/login1";
        }
    }

//    验证码
    @GetMapping("code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        session.setAttribute("code",securityCode);
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png",os);
    }

    //查询用户
    @ResponseBody
    @GetMapping("findUser")
    public DataVO findUser(Integer page, Integer limit){
        return  userService.findUser(page, limit);
    }

    //删除某个用户
    @GetMapping("deleteUser")
    public String deleteUser(String id){
        userService.delete(id);
        return "redirect:/index5";
    }

    //改level名字 和 权限要求等级
    //先查
    @GetMapping("findLevel")
    public String findLevel(Model model){
        List<Levellink> levellinkList = levelLinkMapper.selectList(null);
        List<Permission> permissionList = permissionMapper.selectList(null);
        model.addAttribute("level1",levellinkList.get(0).getLevelName());
        model.addAttribute("level2",levellinkList.get(1).getLevelName());
        model.addAttribute("level3",levellinkList.get(2).getLevelName());
        int gai2 = permissionList.get(1).getGai();
        int gai1 = permissionList.get(0).getGai();
        int shan2 = permissionList.get(1).getShan();
        if(gai1==1 && gai2==1){
            model.addAttribute("gai",1);
        }else if(gai1==0 && gai2==1){
            model.addAttribute("gai",2);
        }else{
            model.addAttribute("gai",3);
        }
        if(shan2 == 1){
            model.addAttribute("shan",2);
        }else{
            model.addAttribute("shan",3);
        }

        return "level";
    }

    //角色名字
    @GetMapping("updatename")
    public String updateName(String level1,String level2,String level3){
        levelLinkMapper.update(level1, "1");
        levelLinkMapper.update(level2, "2");
        levelLinkMapper.update(level3, "3");
        return "level";
    }

    //权限等级
    @GetMapping("updatelevel")
    public String updatelevel(int gai,int shan){
        permissionMapper.gaiadd(gai);
        permissionMapper.gaidel(gai);

        permissionMapper.shanadd(shan);
        permissionMapper.shandel(shan);

        return "level";
    }

    //编辑用户
    @ResponseBody
    @PostMapping("updateuser")
    public String updateuser(@RequestBody User user){
        userMapper.updateById(user);
        return "level";
    }

    //编辑用户
    @GetMapping("levelgai")
    public String levelgai(int level , int id){
        System.out.println("level        :"+level);
        System.out.println("id:        :"+id);
        userMapper.level(level, id);
        return "level";
    }

    //添加用户
    @ResponseBody
    @PostMapping("/adduser")
    public Object adduser(@RequestBody User user){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",user.getUsername());
        User one = userMapper.selectOne(wrapper);
        if(one==null){
            userMapper.insert(user);
            return new Respone(0, "添加成功");
        }else{
            return new Respone(999, "添加失败");
        }
//        return "redirect:/index1";
    }
}
