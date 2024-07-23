package com.albertoor.hen.todo.service;

import com.albertoor.hen.todo.dto.TodoDto;
import com.albertoor.hen.todo.model.Todo;
import com.albertoor.hen.todo.repository.ITodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoService implements ITodoService{
    private final ITodoRepository todoRepository;


    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todoList = todoRepository.findAll();

        if (todoList.isEmpty()) {
            return new ArrayList<>();
        }
        return todoList;
    }

    @Override
    public Todo saveTodo(TodoDto todoDto) {
        Todo todoToSave = Todo.builder()
                .title(todoDto.getTitle()).description(todoDto.getDescription()).isDone(false)
                .build();
        return todoRepository.save(todoToSave);
    }

    @Override
    public Todo getTodoById(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if (!todoOptional.isPresent()) {
            return null;
        }
        return todoOptional.get();
    }

    @Override
    public Todo updateTodoById(Long id, TodoDto todoDto) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if (!todoOptional.isPresent()) {
            return null;
        }
        Todo toUpdated = todoOptional.get();
        toUpdated.setTitle(todoDto.getTitle());
        toUpdated.setDescription(todoDto.getDescription());
        return todoRepository.save(toUpdated);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
