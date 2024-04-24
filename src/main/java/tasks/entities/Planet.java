package tasks.entities;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(name = "id", length = 5)
    @Pattern(regexp = "[A-Z]")
    private String id;


    @Column(name = "name", nullable = false, length = 500)
    private String name;



}