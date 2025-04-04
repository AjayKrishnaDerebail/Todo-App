package com.spring.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String index(Model model) {
    System.out.println("index");
    String page = "home";
    model.addAttribute("page",page);
    return "index";
  }

  @RequestMapping("/add")
  public String addTodo(Model model) {
    System.out.println("index");
    String page = "add";
    model.addAttribute("page",page);
    return "index";
  }
}
