package co.com.sofka.crud.Factory;

import co.com.sofka.crud.Dtos.GroupTodosDto;
import co.com.sofka.crud.Model.GroupTodos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Fabrica de GroupTodos
@Component
public class GroupTodosFactory {

    //Creamos la instancia de la fabrica de Todo
    private TodoFactory todoFactory;

    //Instanciamos el grupo de todos
    public GroupTodosFactory() {
        todoFactory = new TodoFactory();
    }

    //Creamos el grupoDto a partir del grupo original
    public GroupTodosDto createGroupDTO(GroupTodos group){
        GroupTodosDto groupTodos_Dto = new GroupTodosDto(); //Creamos el grupo de todo DTO

        //Le cargamos los datos al DTO
        groupTodos_Dto.setIdGroupTodos(group.getIdGroupTodos());
        groupTodos_Dto.setName(group.getName());

        if(groupTodos_Dto.getTodos() != null) //Si tiene todos, los equipa!
            groupTodos_Dto.setTodos(todoFactory.convertirTodoLista(group.getTodos()));

        return groupTodos_Dto; //Retornamos el grupoDto
    }

    //Mapper para convertir un grupo a un grupoDto
    public List<GroupTodosDto> convertirGroupsDTO(List<GroupTodos> groups){
        List<GroupTodosDto> groups_Dto = groups.stream().map(this::createGroupDTO).collect(Collectors.toList());
        return groups_Dto;
    }

    //Creamos el grupo a partir del grupoDto enviado del fronted
    public GroupTodos createGroupTodos(GroupTodosDto groupTodosDto){

        GroupTodos groupTodos = new GroupTodos(); //Creamos el grupo

        //Le setiamos los datos del mismo
        groupTodos.setIdGroupTodos(groupTodosDto.getIdGroupTodos());
        groupTodos.setName(groupTodosDto.getName());
        groupTodos.setTodos(new ArrayList<>());

        return groupTodos; //Devolvemos el nuevo grupo
    }

}
