package com.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LayuiController {

    @GetMapping("/index")
    public String toindex() {
        return "index";
    }

    @GetMapping("/index1")
    public String toindex1() {
        return "index1";
    }

    @GetMapping("/index2")
    public String toindex2() {
        return "index2";
    }

    @GetMapping("/index3")
    public String toindex3() {
        return "index3";
    }

    @GetMapping("/index4")
    public String toindex4() {
        return "index4";
    }

    @GetMapping("/index5")
    public String toindex5() {
        return "index5";
    }

    @GetMapping("/test")
    public String totest() {
        return "test";
    }

    @GetMapping("/login2")
    public String tologin2() {
        return "login2";
    }

    @GetMapping("/login1")
    public String tologin1() {
        return "login1";
    }

    @GetMapping("/addorder")
    public String toaddorder() {
        return "addorder";
    }

    @GetMapping("/indexx")
    public String toindexx() {
        return "indexx";
    }

    @GetMapping("/bar")
    public String tobar() {
        return "bar";
    }

    @GetMapping("/level")
    public String tolevel() {
        return "level";
    }

    @GetMapping("/welcome")
    public String towelcome() {
        return "welcome";
    }
}
