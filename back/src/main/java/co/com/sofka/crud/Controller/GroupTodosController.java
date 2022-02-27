package co.com.sofka.crud.Controller;

import co.com.sofka.crud.Dtos.GroupTodosDto;
import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Services.GroupTodosServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GroupTodosController { //Controlador para el grupo de quehaceres

    //Instanciamos el Servicio del Grupo
    @Autowired
    private GroupTodosServices groupTodosService;

    // 1) Listar todos los todos, enviando una lista de groupDto
    @GetMapping(value = "api/groups")
    public List<GroupTodosDto> getAllGroups(){
        return groupTodosService.listGroupsTodos();
    }

    // 2) Listar los grupos por ID
    @GetMapping(value = "api/group/{groupID}")
    public GroupTodosDto getGroupById(@PathVariable("groupID") Long groupID){
        return groupTodosService.getGroupById(groupID);
    }

    // 3) Creamos una nueva lista de grupos de todos
    @PostMapping(value = "api/grouptodos")
    public GroupTodosDto createNewGroupTodo(@RequestBody GroupTodosDto group_Dto){
        return groupTodosService.createNewGroupTodo(group_Dto);
    }

    // 4) Eliminar el grupo por la ID
    @DeleteMapping(value = "api/grouptodos/{groupID}")
    public void deleteGroupById(@PathVariable("groupID") Long id){
        groupTodosService.deleteGroupById(id);
    }

    // 5) Trabajar con un todo en especifico
    @PostMapping(value = "api/todo/{groupID}")
    public TodoDto createNewTodoByGroupId(@PathVariable("groupID") Long groupID, @RequestBody TodoDto todo_dto){
        return groupTodosService.createNewTodoByGroupId(groupID, todo_dto);
    }

    // 6) Actualizar un todo por su ID de grupo
    @PutMapping(value = "api/todo/{groupID}")
    public TodoDto updateTodoByGroupId(@PathVariable("groupID") Long groupID, @RequestBody TodoDto todo_dto){

        if(todo_dto.getId() != null){ //Si existe el tododto
            return groupTodosService.updateTodoByGroupId(groupID, todo_dto);
        }
        throw new RuntimeException("El TODO a actualizar debe tener un ID!!!"); //Enviamos excepcion
    }

    // 7) Eliminar por ID del todo
    @DeleteMapping(value = "api/todo/{todoID}")
    public void deleteTodoById(@PathVariable("todoID") Long todoID){
        groupTodosService.deleteTodoById(todoID);
    }

}
