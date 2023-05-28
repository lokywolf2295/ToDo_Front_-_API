package ar.com.utnfrsr.todoapp.service;

import ar.com.utnfrsr.todoapp.model.dto.TaskInDTO;
import ar.com.utnfrsr.todoapp.model.mapper.TaskInDTOToTask;
import ar.com.utnfrsr.todoapp.repository.TastkRepository;
import ar.com.utnfrsr.todoapp.exceptions.ToDoExceptions;
import ar.com.utnfrsr.todoapp.model.entity.Task;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //le dice al contenedor bin de spring, que cree un bin y lo guarde en ese contenedor, para luego ser identado donde se lo necesite
@RequiredArgsConstructor
public class TaskService {

    //en el service va toda la lógica necesaria para el programa.
    private final TastkRepository repository;
    private final TaskInDTOToTask mapper;

    //Crea la tarea
    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    //muestra la lista de tareas
    public List<Task> findAll() {
        return this.repository.findAll();
    }

    //actualiza el estado de la tarea
    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) { //si no hay taréa
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
       this.repository.markTaskAsFinished(id);
    }

    //elimina el task mediante su id
    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }
}
