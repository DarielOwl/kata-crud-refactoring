package co.com.sofka.crud.Model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
public class GroupTodos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idGroupTodos;

    @Column(length = 25, nullable = false)
    private String name;

    @OneToMany(mappedBy = "groupTodos")
    @Cascade(CascadeType.DELETE)
    private List<Todo> todos;

    //Getters
    public long getIdGroupTodos() {
        return idGroupTodos;
    }

    public String getName() {
        return name;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    //Setters
    public void setIdGroupTodos(long idGroupTodos) {
        this.idGroupTodos = idGroupTodos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

}
