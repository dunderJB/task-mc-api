package com.api.task.entities;

import com.api.task.enums.TaskEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;
    private Integer stats;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Task(){
    }

    public Task(Long id, String title, String body, TaskEnum stats, Client client){
        this.id = id;
        this.title = title;
        this.body = body;
        this.stats = stats.getCod();
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public TaskEnum getStats() {
        return TaskEnum.toEnum(stats);
    }

    public void setStats(TaskEnum stats) {
        this.stats = stats.getCod();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
