package Tasks.Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(name = "id", length = 5)
    private String id;

    @Column(name = "name", nullable = false, length = 500)
    private String name;



}