package com.kaizencode.sensei.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExerciseController {

    @GetMapping("/exercises/list")
    public String list(){
        return "exercises/list";
    }

}
