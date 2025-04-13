package com.spring.todo.controller;

import com.spring.todo.entities.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

  /*
    @Autowired
    ServletContext context;
  */

  @RequestMapping("/")
  public String index(Model model) {
    System.out.println("index");
    String page = "home";
    model.addAttribute("page", page);
    /*
      List<Todo> todoList = (List<Todo>) context.getAttribute("todoList");
      model.addAttribute("todoList", todoList);
    */
    return "index";
  }

  @RequestMapping("/add")
  public String addTodo(Model model) {
    System.out.println("index");
    String page = "add";
    model.addAttribute("page", page);
    Todo todo = new Todo();
    model.addAttribute("todo", todo);
    return "index";
  }

  @RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
  public String saveTodo(@ModelAttribute("todo") Todo t, Model model) {
    /*
      List<Todo> todoList = (List<Todo>) context.getAttribute("todoList");
      todoList.add(t);
      model.addAttribute("message","Successfully added");
    */
    System.out.println("Successfully added");
    return "index";
  }

}
