package fr.lernejo.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class TodoListController {

    private final ArrayList<Todo> todos = new ArrayList<>();

    @PostMapping(value = "/todo")
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        todos.add(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @GetMapping(value = "/todo")
    public ResponseEntity<ArrayList<Todo>> getAll() {
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
}
