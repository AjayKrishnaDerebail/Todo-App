package com.spring.todo.listener;

import com.spring.todo.entities.Todo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

public class MyListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("Context initialized...");
/*    List<Todo> todoList = new ArrayList<>();
    ServletContext context = sce.getServletContext();
    context.setAttribute("todoList", todoList);*/
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("Context destroyed...");
  }
}
