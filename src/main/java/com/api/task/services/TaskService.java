package com.api.task.services;

import com.api.task.entities.Task;
import com.api.task.repositories.TaskRepository;
import com.api.task.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task findTaskById(Long id){
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(()-> new ObjectNotFoundException("Task not found"));
    }

    public List<Task> findAllTasks(){
        List<Task> listTask = taskRepository.findAll();
        return listTask;
    }

    public Task insertTask(Task obj){
        taskRepository.save(obj);
        return obj;
    }

    public Task updateTask(Task obj){
        findTaskById(obj.getId());
        Task task = taskRepository.save(obj);
        return task;
    }

    public void deleteTask(Long id){
        findTaskById(id);
        taskRepository.deleteById(id);
    }

}
