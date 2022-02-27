package co.com.sofka.crud.Dtos;

//DTO para transportar la info de los quehaceres
public class TodoDto {

    private Long id;
    private String name;
    private boolean completed;
    private Long groupTodoId;

    //Constructor por defecto
    public TodoDto() {}

    //Constructor con argumentos 1
    public TodoDto(Long id, String name, boolean completed, Long groupTodoId) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.groupTodoId = groupTodoId;
    }

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

    public Long getGroupTodoId() {
        return groupTodoId;
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

    public void setGroupTodoId(Long groupTodoId) {
        this.groupTodoId = groupTodoId;
    }

}
