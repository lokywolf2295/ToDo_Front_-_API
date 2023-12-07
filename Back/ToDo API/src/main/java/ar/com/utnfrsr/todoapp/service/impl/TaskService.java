package ar.com.utnfrsr.todoapp.service.impl;

import ar.com.utnfrsr.todoapp.exceptions.ToDoExceptions;
import ar.com.utnfrsr.todoapp.model.dto.request.TaskRequestDTO;
import ar.com.utnfrsr.todoapp.model.dto.response.TaskResponseDTO;
import ar.com.utnfrsr.todoapp.model.entity.Task;
import ar.com.utnfrsr.todoapp.model.mapper.TaskMapper;
import ar.com.utnfrsr.todoapp.repository.TastkRepository;
import ar.com.utnfrsr.todoapp.service.ITaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//le dice al contenedor bin de spring, que cree un bin y lo guarde en ese contenedor, para luego ser identado donde se lo necesite
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    //en el service va toda la lógica necesaria para el programa.
    private final TastkRepository repository;
    private final TaskMapper mapper;

    //Crea la tarea
    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = mapper.toTask(taskRequestDTO);
        return mapper.toDTO(repository.save(task));
    }

    //muestra la lista de tareas
    @Override
    public List<TaskResponseDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    //actualiza el estado de la tarea
    @Override
    @Transactional
    public void updateTaskAsFinished(Long id, boolean finished) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) { //si no hay taréa
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        finished = !finished;
        this.repository.markTaskAsFinished(id, finished);
    }

    //elimina el task mediante su id
    @Override
    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
