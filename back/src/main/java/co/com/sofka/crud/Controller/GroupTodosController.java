package co.com.sofka.crud.Controller;

import co.com.sofka.crud.Dtos.GroupTodosDto;
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

    //1) Listar todos los todos, enviando una lista de groupDto
    @GetMapping(value = "api/groups")
    public List<GroupTodosDto> getAllGroups(){
        return groupTodosService.listGroupsTodos();
    }

}
