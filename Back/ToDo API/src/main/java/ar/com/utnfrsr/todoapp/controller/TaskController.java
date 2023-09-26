package ar.com.utnfrsr.todoapp.controller;

import ar.com.utnfrsr.todoapp.model.dto.TaskInDTO;
import ar.com.utnfrsr.todoapp.model.entity.Task;
import ar.com.utnfrsr.todoapp.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController /*Anotación para confirmar de que se trata de un controlador el cual será revisado por swagger*/
@RequestMapping("api/v1/tasks")
public class TaskController { //esta capa solo se comunica con la capa de servicio

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping("/all")
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @PatchMapping("/mark_as_finished/{id}/{finished}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id, @PathVariable("finished") boolean finished) {
        this.taskService.updateTaskAsFinished(id,finished);
        return ResponseEntity.noContent().build(); //luego de que se ejecute la tarea devuelve un 204 siempre
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}