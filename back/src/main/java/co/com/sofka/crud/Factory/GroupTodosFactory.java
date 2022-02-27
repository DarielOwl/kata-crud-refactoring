package co.com.sofka.crud.Factory;

import co.com.sofka.crud.Dtos.GroupTodosDto;
import co.com.sofka.crud.Model.GroupTodos;
import org.springframework.stereotype.Component;

@Component
public class GroupTodosFactory {

    //Creamos la instancia de la fabrica de Todo
    private TodoFactory todoFactory;

    //Instanciamos el grupo de todos
    public GroupTodosFactory() {
        todoFactory = new TodoFactory();
    }

    //Creamos el grupoDto a partir del grupo original
    public GroupTodosDto toGroupDTO(GroupTodos group){
        GroupTodosDto groupTodos_Dto = new GroupTodosDto(); //Creamos el grupo de todo DTO

        //Le cargamos los datos al DTO
        groupTodos_Dto.setIdGroupTodos(group.getIdGroupTodos());
        groupTodos_Dto.setName(group.getName());

        if(groupTodos_Dto.getTodos() != null) //Si tiene todos, los equipa!
            groupTodos_Dto.setTodos(todoFactory.convertirTodoLista(group.getTodos()));

        return groupTodos_Dto; //Retornamos el grupoDto
    }
}
