package co.com.sofka.crud.Model;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "idGroupTodos", referencedColumnName = "idGroupTodos")
    private GroupTodos groupTodos;

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public GroupTodos getGroupTodos() {
        return groupTodos;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setGroupTodos(GroupTodos groupTodos) {
        this.groupTodos = groupTodos;
    }
}
