package co.com.sofka.crud.Services;

import co.com.sofka.crud.Repository.GroupTodosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupTodosServices {

    //Generamos instancia del grupo de todo
    @Autowired
    private GroupTodosRepository GroupTodosRepository;


}
