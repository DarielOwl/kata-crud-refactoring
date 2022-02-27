package co.com.sofka.crud.Dtos;

import java.util.ArrayList;
import java.util.List;

//DTO para transportar la info de los grupos
public class GroupTodosDto {

    private long idGroupTodos;
    private String name;
    private List<TodoDto> todos = new ArrayList<>();

    //Constructor por defecto
    public GroupTodosDto() {}

    //Constructor con argumentos 1
    public GroupTodosDto(long idGroupTodos, String name, List<TodoDto> todos) {
        this.idGroupTodos = idGroupTodos;
        this.name = name;
        this.todos = todos;
    }

    //Getters
    public long getIdGroupTodos() {
        return idGroupTodos;
    }

    public String getName() {
        return name;
    }

    public List<TodoDto> getTodos() {
        return todos;
    }

    //Setters
    public void setIdGroupTodos(long idGroupTodos) {
        this.idGroupTodos = idGroupTodos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTodos(List<TodoDto> todos) {
        this.todos = todos;
    }

}
