package fr.m2i.todolist.util;

import fr.m2i.todolist.model.Todo;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.LinkedList;

@XmlRootElement(name = "Todos")
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
    public String getTodoFromId(int id) throws IndexOutOfBoundsException {
        if(id < 0 || id >= this.todoList.size()) {
            throw new IndexOutOfBoundsException(String.format("Pas de Todo à l'index %d", id));
        }
        return this.todoList.get(id).toString();
    }

    public void deleteTodo(int id) {
        this.todoList.remove(id);
    }

    @XmlElement(name="todo")
    @XmlElementWrapper(name = "list")
    public LinkedList<Todo> getTodoList() {
        return todoList;
    }

    public void updateTodoFromId(int id, Todo updatedTodo) {
        this.todoList.set(id, updatedTodo);
    }
}
