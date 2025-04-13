package com.spring.todo.controller;

import com.spring.todo.entities.Todo;
import com.spring.todo.repositories.TodoDao;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

  /*
   *
    @Autowired
    ServletContext context;
  */

  private final TodoDao todoDao;

  public HomeController(TodoDao todoDao) {
    this.todoDao = todoDao;
  }

  @RequestMapping("/")
  public String index(Model model) {
    System.out.println("index");
    String page = "home";
    model.addAttribute("page", page);
    /*
     *
      List<Todo> todoList = (List<Todo>) context.getAttribute("todoList");
      model.addAttribute("todoList", todoList);
    */
    List<Todo> todoList = this.todoDao.getTodoList();
    model.addAttribute("todoList", todoList);
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
     *
      List<Todo> todoList = (List<Todo>) context.getAttribute("todoList");
      todoList.add(t);
    */
    this.todoDao.saveTodo(t);
    System.out.println("Successfully added");
    model.addAttribute("message","Successfully added");
    return "index";

    /*
     * You’re telling Spring:
     * After the POST is done, send an HTTP redirect response to the browser so it makes a GET request to /
     * So the flow becomes:
        POST /saveTodo
        Save todo
        Spring returns redirect:/
        Browser sees the redirect and makes a new GET request to /
        / controller loads and renders fresh index.jsp
        Refresh now just re-runs the GET
     */


  }

}
