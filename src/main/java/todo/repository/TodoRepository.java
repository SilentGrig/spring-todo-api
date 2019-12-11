package todo.repository;

import todo.model.Todo;

import java.util.*;

public class TodoRepository {
    private final Map<String, Todo> todos = new LinkedHashMap<>();

    private TodoRepository() {}

    private static TodoRepository repository = null;

    public static TodoRepository createRepository() {
        if (repository == null) {
            repository = new TodoRepository();
        }
        return repository;
    }

    public Todo addTodo(Todo newTodo) {
        if (todos.containsKey(newTodo.getId())) {
            return null;
        }
        todos.put(newTodo.getId(), newTodo);
        return newTodo;
    }

    public List<Todo> getAllTodos() {
        List<Todo> todoList = new ArrayList<>();
        todoList.addAll(todos.values());
        return todoList;
    }

    public void deleteAllTodos() {
        todos.clear();
    }

    public Todo getTodo(String id) {
        return todos.get(id);
    }

    public void deleteTodo(String id) {
        if (!todos.containsKey(id)) {
            return;
        }
        todos.remove(id);
    }
}
