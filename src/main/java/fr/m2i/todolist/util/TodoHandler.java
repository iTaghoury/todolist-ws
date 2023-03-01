package fr.m2i.todolist.util;

import fr.m2i.todolist.model.Todo;

import java.util.LinkedList;

public class TodoHandler {
    private LinkedList<Todo> todoList;
    private static TodoHandler instance;
    static {
        instance = null;
    }
    private TodoHandler() {
        instance = this;
        this.todoList = new LinkedList<>();
    }

    public static TodoHandler getInstance() {
        if(instance == null) {
            return new TodoHandler();
        } else {
            return instance;
        }
    }

    public void addTodo(Todo todo) {
        this.todoList.add(todo);
    }

    public StringBuilder viewTodoList() {
        StringBuilder sb = new StringBuilder();
        sb.append("TodoList : \n");
        for(Todo todo : this.todoList) {
            sb.append(String.format("Todo %d : %s\n", this.todoList.indexOf(todo),todo.toString()));
        }
        return sb;
    }

    public String getTodoFromId(int id) {
        return this.todoList.get(id).toString();
    }

    public void deleteTodo(int id) {
        this.todoList.remove(id);
    }

    public LinkedList<Todo> getTodoList() {
        return todoList;
    }

    public void updateTodoFromId(int id, Todo updatedTodo) {
        this.todoList.set(id, updatedTodo);
    }
}
