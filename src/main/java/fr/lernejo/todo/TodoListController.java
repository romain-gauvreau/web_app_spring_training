package fr.lernejo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoListController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping(value = "/todo")
    public ResponseEntity<TodoEntity> create(@RequestBody TodoEntity todo) {
        this.todoRepository.save(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @GetMapping(value = "/todo")
    public ResponseEntity<List<TodoEntity>> getAll() {
        List<TodoEntity> todoList = new ArrayList<>();
        todoRepository.findAll().forEach(todoList::add);
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }
}
