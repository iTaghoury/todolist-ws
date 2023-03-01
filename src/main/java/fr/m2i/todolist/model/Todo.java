package fr.m2i.todolist.model;

public class Todo {
    private String titre, description, urgence;

    public Todo(String titre, String description, String urgence) {
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

    public String getUrgence() {
        return urgence;
    }

    public void setUrgence(String urgence) {
        this.urgence = urgence;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", urgence='" + urgence + '\'' +
                '}';
    }
}
