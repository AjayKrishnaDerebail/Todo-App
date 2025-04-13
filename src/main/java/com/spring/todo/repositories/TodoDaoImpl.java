package com.spring.todo.repositories;

import com.spring.todo.entities.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@Getter
@Setter
public class TodoDaoImpl implements TodoDao{

  /*
    @PersistenceContext is the correct annotation for injecting EntityManager in JPA (even when using Spring).
    Spring will manage it automatically from your LocalContainerEntityManagerFactoryBean
   */
  @PersistenceContext
  EntityManager entityManager;

  @Override
  @Transactional
  public void saveTodo(Todo t) {
    entityManager.persist(t);
  }

  @Override
  public List<Todo> getTodoList() {
    String jpql = "SELECT t FROM Todo t";
    // 'Todo' is the class name, not the table name
    return entityManager.createQuery(jpql, Todo.class).getResultList();

  }
}