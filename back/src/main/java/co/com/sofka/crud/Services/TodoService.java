package co.com.sofka.crud.Services;

import co.com.sofka.crud.Dtos.TodoDto;
import co.com.sofka.crud.Factory.TodoFactory;
import co.com.sofka.crud.Repository.TodoRepository;
import co.com.sofka.crud.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    //Creamos la instancia del Fabrica de Todo
    @Autowired
    private TodoFactory todosFactory;

    // 1) Mostrar todos los Todos
    public List<TodoDto> list(){
        List<Todo> todos = (List<Todo>) repository.findAll();
        return todosFactory.convertirTodoLista(todos);
    }

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }

}
