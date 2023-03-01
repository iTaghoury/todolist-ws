package fr.m2i.todolist.model;

public class Todo {
    private String titre, description;
    private Urgence urgence;

    public Todo(String titre, String description, Urgence urgence) {
        this.titre = titre;
        this.description = description;
        this.urgence = urgence;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Urgence getUrgence() {
        return urgence;
    }

    public void setUrgence(Urgence urgence) {
        this.urgence = urgence;
    }
}
