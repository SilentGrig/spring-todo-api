package todo.domain;

import todo.model.Todo;
import todo.param.TodoParam;
import todo.repository.TodoRepository;

import java.util.List;

public class TodoDomain {
    private TodoRepository repository = TodoRepository.createRepository();

    public Todo createNewTodo(TodoParam param) {
        if(param.getContent().isEmpty()) {
            return null;
        }
        Todo newTodo = new Todo(param.getContent());
        repository.addTodo(newTodo);
        return newTodo;
    }

    public Todo findTodoById(String id) {
        return repository.getTodo(id);
    }

    public List<Todo> getAllTodos() {
        return repository.getAllTodos();
    }

    public void deleteAllTodos() {
        repository.deleteAllTodos();
    }

    public void deleteTodo(String id) {
        repository.deleteTodo(id);
    }

    public Todo updateTodo(String id, TodoParam param) {
        Todo todo = repository.getTodo(id);
        if (todo == null) {
            return null;
        }
        if(param.getContent() != null && !param.getContent().isEmpty()) {
            todo.setContent(param.getContent());
        }
        if(param.getCompleted() != todo.getCompleted()) {
            todo.setCompleted(param.getCompleted());
        }
        return todo;
    }
}
