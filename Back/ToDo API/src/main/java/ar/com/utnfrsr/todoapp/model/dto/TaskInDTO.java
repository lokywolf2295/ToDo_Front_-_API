package ar.com.utnfrsr.todoapp.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TaskInDTO {

    private String title;
    private LocalDate date;
    private LocalTime time;
}
