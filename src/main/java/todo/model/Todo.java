package todo.model;

import java.util.UUID;

public class Todo {
    private final String id;
    private String content;
    private boolean completed;

    public Todo(String content) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.completed = false;
    }

    public String getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean isCompleted) {
        this.completed = isCompleted;
    }
}
