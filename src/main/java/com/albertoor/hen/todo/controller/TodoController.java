package com.albertoor.hen.todo.controller;

import com.albertoor.hen.todo.dto.TodoDto;
import com.albertoor.hen.todo.model.Todo;
import com.albertoor.hen.todo.service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo")
    public String todoForm(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("todos", todoService.getAllTodos());
        return "todo";
    }

    @PostMapping("/todo")
    public String todoSubmit(@Valid @ModelAttribute("todo") TodoDto todoDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Todo> todoList = todoService.getAllTodos();
            model.addAttribute("todos", todoList);
            return "todo";
        }

        Todo todoSaved = todoService.saveTodo(todoDto);
        model.addAttribute("todo", todoSaved);
        return "redirect:/todo";
    }

    @PostMapping("/todo/update/{id}")
    public String todoUpdateById(@PathVariable("id") Long id, @Valid TodoDto todoDto,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "todo/update";
        }
        todoService.updateTodoById(id, todoDto);

        return "redirect:/todo";
    }

    @GetMapping("/todo/edit/{id}")
    public String todoEditForm(@PathVariable("id") Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "edit-todo";
    }

    @GetMapping("/todo/delete/{id}")
    public String showDeleteTodoConfirmation(@PathVariable("id") Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo",todo);
        return "confirm-todo-delete";
    }

    @PostMapping("/todo/delete/{id}")
    public String todoDeleteById(@PathVariable("id") Long id,  Model model) {
        todoService.deleteTodoById(id);
        return "redirect:/todo";
    }
}
