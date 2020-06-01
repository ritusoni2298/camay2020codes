package com.example.app.todoapp.controller;

import com.example.app.todoapp.models.Todo;
import com.example.app.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;

    //get
    @GetMapping("/todo")
    List<Todo> getAllTasks(){
        return todoRepository.findAll(); //select * from todo;
    }
    //post
    @PostMapping("/todo")
    ResponseEntity<Todo> addTask(@Valid @RequestBody Todo todo){
        todo.setCompleted(false);
        todoRepository.save(todo);
        return ResponseEntity.ok().body(todo);
    }

    //put
    @PutMapping("/todo/{id}")
    ResponseEntity<Todo> updateTask(@Valid @RequestBody Todo todo, @PathVariable String id){
        return todoRepository.findById(id).map(
                oldTodo -> {
                    oldTodo.setTitle(todo.getTitle());
                    oldTodo.setCompleted(todo.getCompleted());
                    todoRepository.save(oldTodo);
                    return ResponseEntity.ok().body(oldTodo);
                }).orElse(ResponseEntity.notFound().build());
    }

    //delete
    @DeleteMapping("/todo/{id}")
    ResponseEntity<?> deleteTask(@PathVariable String id) {
        return todoRepository.findById(id).map(
                todo-> {
                    todoRepository.delete(todo);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
