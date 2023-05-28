package ar.com.utnfrsr.todoapp.model.mapper;

import ar.com.utnfrsr.todoapp.model.entity.Task;
import ar.com.utnfrsr.todoapp.model.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component /*de esta manera lo podremos indentar en nuestras clases*/
public class TaskInDTOToTask {

    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDate(in.getDate());
        task.setTime(in.getTime());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);

        return task;
    }
}
