package co.com.sofka.crud.Services;

import co.com.sofka.crud.Dtos.GroupTodosDto;
import co.com.sofka.crud.Factory.GroupTodosFactory;
import co.com.sofka.crud.Factory.TodoFactory;
import co.com.sofka.crud.Model.GroupTodos;
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

    // 1) Listar todos los todos, enviando una lista de groupDto---------------------
    public List<GroupTodosDto> listGroupsTodos(){
        List<GroupTodos> groups = (List<GroupTodos>) GroupTodosRepository.findAll();
        return groupTodosFactory.convertirGroupsDTO(groups); //Retornamos un grupo_Dto ya cargado con datos
    }
}
