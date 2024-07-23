package com.albertoor.hen.todo.service;

import com.albertoor.hen.todo.dto.TodoDto;
import com.albertoor.hen.todo.model.Todo;

import java.util.List;

public interface ITodoService {

    List<Todo> getAllTodos();

    Todo saveTodo(TodoDto todoDto);

    Todo getTodoById(Long id);

    Todo updateTodoById(Long id, TodoDto todoDto);

    void deleteTodoById(Long id);
}
