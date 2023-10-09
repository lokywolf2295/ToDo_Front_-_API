package ar.com.utnfrsr.todoapp.model.mapper;

import ar.com.utnfrsr.todoapp.model.dto.request.TaskRequestDTO;
import ar.com.utnfrsr.todoapp.model.entity.Task;
import ar.com.utnfrsr.todoapp.model.dto.response.TaskResponseDTO;
import org.springframework.stereotype.Component;

@Component /*de esta manera lo podremos indentar en nuestras clases*/
public class TaskMapper {

        public Task toTask(TaskRequestDTO taskRequestDTO) {
            Task task = new Task();
            task.setTitle(taskRequestDTO.getTitle());
            task.setDate(taskRequestDTO.getDate());
            task.setTime(taskRequestDTO.getTime());
            return task;
        }

        public TaskResponseDTO toDTO(Task task) {
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
            taskResponseDTO.setId(task.getId());
            taskResponseDTO.setTitle(task.getTitle());
            taskResponseDTO.setDate(task.getDate());
            taskResponseDTO.setTime(task.getTime());
            return taskResponseDTO;
        }
}
