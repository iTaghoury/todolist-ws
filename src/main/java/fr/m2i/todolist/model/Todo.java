package fr.m2i.todolist.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Todo {
    private String titre, description, urgence;

    public Todo() {}
    public Todo(String titre, String description, String urgence) {
        this.titre = titre;
        this.description = description;
        this.urgence = urgence;
    }
    @XmlElement()
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    @XmlElement()
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @XmlElement()
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
