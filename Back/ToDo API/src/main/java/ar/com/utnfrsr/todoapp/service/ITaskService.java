package ar.com.utnfrsr.todoapp.service;

import ar.com.utnfrsr.todoapp.model.dto.request.TaskRequestDTO;
import ar.com.utnfrsr.todoapp.model.dto.response.TaskResponseDTO;

import java.util.List;

public interface ITaskService {

    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);

    List<TaskResponseDTO> findAll();

    void updateTaskAsFinished(Long id, boolean finished);

    void deleteById(Long id);
}
