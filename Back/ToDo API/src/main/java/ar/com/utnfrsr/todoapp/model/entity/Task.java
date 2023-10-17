package ar.com.utnfrsr.todoapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data /*Para obtener los getter and setter de la clase*/
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
@SQLDelete(sql = "UPDATE task SET enable = false WHERE id = ?")
@Where(clause = "enable = true")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 20)
    private Long id;
    @Column(name = "title", nullable = false, length = 256)
    private String title;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "time", nullable = false)
    private LocalTime time;
    @Column(name = "finished", nullable = false)
    private boolean finished;
    @Column(name = "enable")
    private boolean enabled = true;
}
