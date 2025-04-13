package com.spring.todo.repositories;


import com.spring.todo.entities.Todo;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao {
  void saveTodo(Todo t);

  List<Todo> getTodoList();

}
