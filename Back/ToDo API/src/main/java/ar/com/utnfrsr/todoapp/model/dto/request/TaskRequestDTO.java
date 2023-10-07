package ar.com.utnfrsr.todoapp.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class TaskRequestDTO {

    @NotNull
    private String title;
    @NotNull
    private Date date;
    @NotNull
    private LocalTime time;
}
