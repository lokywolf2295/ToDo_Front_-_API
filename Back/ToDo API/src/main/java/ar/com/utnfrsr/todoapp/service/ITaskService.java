package ar.com.utnfrsr.todoapp.service;

import ar.com.utnfrsr.todoapp.model.dto.request.TaskRequestDTO;
import ar.com.utnfrsr.todoapp.model.entity.Task;

import java.util.List;

public interface ITaskService {

    Task createTask(TaskRequestDTO taskRequestDTO);
    List<Task> findAll();
    void updateTaskAsFinished(Long id, boolean finished);
    void deleteById(Long id);
}
