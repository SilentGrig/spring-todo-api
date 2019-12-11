package todo.controller;

import org.springframework.web.bind.annotation.*;

import todo.domain.TodoDomain;
import todo.model.Todo;
import todo.param.TodoParam;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/todos")
class TodoController {
    private TodoDomain todoDomain = new TodoDomain();

    @GetMapping
    public List allTodos() {
        return todoDomain.getAllTodos();
    }

    @PostMapping
    public Todo createTodo(@RequestBody TodoParam todoParam) {
        return todoDomain.createNewTodo(todoParam);
    }

    @DeleteMapping
    public void deleteTodos() {
        todoDomain.deleteAllTodos();
    }

    @GetMapping(value="/{id}")
    public Todo findById(@PathVariable String id) {
        return todoDomain.findTodoById(id);
    }

    @PutMapping(value="/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody TodoParam param) {
        return todoDomain.updateTodo(id, param);
    }

    @DeleteMapping(value="/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoDomain.deleteTodo(id);
    }
}
