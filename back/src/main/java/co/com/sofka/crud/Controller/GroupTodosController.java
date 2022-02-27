package co.com.sofka.crud.Controller;

import co.com.sofka.crud.Services.GroupTodosServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GroupTodosController { //Controlador para el grupo de quehaceres

    //Instanciamos el Servicio del Grupo
    @Autowired
    private GroupTodosServices groupTodosService;

    

}
