package co.com.sofka.crud.Factory;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Model.Todo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//Fabrica de Todos
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

    //Mapper para convertir de todoDto a un todo
    public Todo createTodo(TodoDto todo_dto){
        Todo todo = new Todo(); //Creamos el objeto todo

        //Le setiamos los valores
        todo.setId(todo_dto.getId());
        todo.setName(todo_dto.getName());
        todo.setCompleted(todo_dto.isCompleted());

        return todo; //Y retornamos el nuevo objeto
    }


}
