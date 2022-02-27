package co.com.sofka.crud.Services;

import co.com.sofka.crud.Dtos.GroupTodosDto;
import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Factory.GroupTodosFactory;
import co.com.sofka.crud.Factory.TodoFactory;
import co.com.sofka.crud.Model.GroupTodos;
import co.com.sofka.crud.Model.Todo;
import co.com.sofka.crud.Repository.GroupTodosRepository;

import co.com.sofka.crud.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupTodosServices {

    //Generamos instancia del Grupo del Repositorio
    @Autowired
    private GroupTodosRepository GroupTodosRepository;

    //Creamos la instancia del Grupo de Fabrica
    @Autowired
    private GroupTodosFactory groupTodosFactory;

    //Generamos instancia del Todo del Repositorio
    @Autowired
    private TodoRepository todoRepository;

    //Generamos instancia del Todo de Fabrica
    @Autowired
    private TodoFactory todoFactory;

    // 1) Listar todos los todos, enviando una lista de groupDto
    public List<GroupTodosDto> listGroupsTodos(){
        List<GroupTodos> groups = (List<GroupTodos>) GroupTodosRepository.findAll();
        return groupTodosFactory.convertirGroupsDTO(groups); //Retornamos un grupo_Dto ya cargado con datos
    }

    // 2) Listar los grupos por ID
    public GroupTodosDto getGroupById(Long groupID) {
        GroupTodos groupT = GroupTodosRepository.findById(groupID).orElseThrow(); //Busca el grupo por su ID, si no existe salta una excepcion
        return groupTodosFactory.createGroupDTO(groupT); //Retornamos un grupo_Dto ya cargado con datos
    }

    // 3) Creamos una nueva lista de grupos de todos
    public GroupTodosDto createNewGroupTodo(GroupTodosDto group_dto) {

        //Verificamos que el campo nombre este vacio
        if(group_dto.getName() == null || group_dto.getName().trim().isEmpty()){
            throw new RuntimeException("NOMBRE no puede estar VACIO!!!");
        }

        // Convertimos el gourp_dto a group para guardar
        GroupTodos newGroupTodos = groupTodosFactory.createGroupTodos(group_dto);

        //Guardamos en la Base de Datos
        GroupTodosRepository.save(newGroupTodos);

        //Retornamos el DTO
        return group_dto = groupTodosFactory.createGroupDTO(newGroupTodos);
    }

    // 4) Eliminar el grupo por la ID
    public void deleteGroupById(Long id) {

        // Verificar si existe el grupo que tenga dicha ID, sino salta la excepcion
        GroupTodos groupTodos = GroupTodosRepository.findById(id).orElseThrow(() -> new RuntimeException("El id del grupo no existe"));
        GroupTodosRepository.deleteById(id); //Si existe la ELIMINA
    }

    // 5) Trabajar con un todo en especifico
    public TodoDto createNewTodoByGroupId(Long groupID, TodoDto todo_dto) {

        //Verificamos que el campo nombre este vacio
        if(todo_dto.getName() == null || todo_dto.getName().trim().isEmpty()){
            throw new RuntimeException("NOMBRE no puede estar VACIO!!!");
        }

        //Verificar si existe el grupo que tenga dicha ID, sino salta la excepcion
        GroupTodos groupTodos = GroupTodosRepository.findById(groupID).orElseThrow(() -> new RuntimeException("El id del grupo no existe"));

        //Creamos un nuevo todo con los datos del todo_dto
        Todo newTodo = todoFactory.createTodo(todo_dto);

        //Se le asigna el grupo correspondiente al nuevo todo
        newTodo.setGroupTodos(groupTodos);

        //Guardamos en la Base de Datos
        todoRepository.save(newTodo);

        //Devolvemos el DTO
        return todo_dto = todoFactory.createTodoDTO(newTodo);
    }

    // 6) Actualizar un todo por su ID de grupo
    public TodoDto updateTodoByGroupId(Long groupID, TodoDto todo_dto) {

        //Verificar si existe el grupo que tenga dicha ID, sino salta la excepcion
        GroupTodos groupTodos = GroupTodosRepository.findById(groupID).orElseThrow(() -> new RuntimeException("El id del grupo no existe"));

        //Verificar que exista la ID del todo
        todoRepository.findById(todo_dto.getId()).orElseThrow(() -> new RuntimeException("No existe un TODO con el ID ingresado!!!"));

        //Creamos un nuevo todo con los datos del todo_dto
        Todo newTodo = todoFactory.createTodo(todo_dto);

        //Se le asigna el grupo correspondiente al nuevo todo
        newTodo.setGroupTodos(groupTodos);

        //Se busca en el grupo el viejoTodo con el ID para asignarle los valores y así actualizar
        groupTodos.getTodos().stream().forEach( (viejoTodo) -> {

            if(viejoTodo.getId() == newTodo.getId()){ //Si encontramos el todo lo actualizamos

                //Actualizamos los datos
                viejoTodo.setName(newTodo.getName());
                viejoTodo.setCompleted(newTodo.isCompleted());
                viejoTodo.setId(newTodo.getId());
            }
        });

        //Se le pasa al todo el grupo actualizado
        newTodo.setGroupTodos(groupTodos);

        //Se almacena en BD los nuevos cambios
        GroupTodosRepository.save(groupTodos);

        //Se convierte a DTO para finalizar
        return todo_dto = todoFactory.createTodoDTO(newTodo);
    }

    // 7) Eliminar por ID del todo
    public void deleteTodoById(Long todoID) {

        // Verificar que existe la ID del todo
        Todo todo = todoRepository.findById(todoID).orElseThrow(() -> new RuntimeException("El TODO con ID especificado NO EXISTE!!!"));
        todoRepository.delete(todo); //Si lo encontramos borramos
    }
}
