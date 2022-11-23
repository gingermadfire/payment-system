package com.gingermadfire.testtask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/billers")
public class BillerController {

    @GetMapping
    public String getBillersPage() {
        return "billers";
    }
}
