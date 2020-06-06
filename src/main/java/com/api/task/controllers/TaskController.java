package com.api.task.controllers;

import com.api.task.entities.Task;
import com.api.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Task>> findAllTasks(){
        List<Task> listTask = taskService.findAllTasks();
        return ResponseEntity.ok().body(listTask);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> findTaskById(@PathVariable Long id){
        Task task = taskService.findTaskById(id);
        return ResponseEntity.ok().body(task);
    }

    @RequestMapping(value = "/new-task", method = RequestMethod.POST)
    public ResponseEntity<Void> insertTask(@RequestBody Task obj){
        taskService.insertTask(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/nameTask").buildAndExpand(obj.getTitle()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/update-task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateTask(@RequestBody Task obj, @PathVariable Long id){
        obj.setId(id);
        taskService.updateTask(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/delete-task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
