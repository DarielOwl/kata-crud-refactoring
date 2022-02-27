package co.com.sofka.crud.Factory;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Model.Todo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoFactory {

    //Crea los DTO a partir del objeto original todo
    public TodoDto createTodoDTO(Todo todo){
        TodoDto todo_Dto = new TodoDto(); //Cramos el dto

        //Le seteamos los datos
        todo_Dto.setId(todo.getId());
        todo_Dto.setCompleted(todo.isCompleted());
        todo_Dto.setName(todo.getName());

        if(todo.getGroupTodos() != null) //Si tiene grupos, lo equipamos al dto
            todo_Dto.setGroupTodoId(todo.getGroupTodos().getIdGroupTodos());

        return todo_Dto; //Retornamos el dto ya creado
    }

    //Mapper para convertir una lista de todo a una lista de todoDto
    public List<TodoDto> convertirTodoLista(List<Todo> todos){
        List<TodoDto> todos_Dto = todos.stream().map(this::createTodoDTO).collect(Collectors.toList());

        return todos_Dto;
    }




}
