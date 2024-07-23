package com.albertoor.hen.todo.repository;

import com.albertoor.hen.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Long> {
}
