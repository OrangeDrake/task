package petrfiala.task.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 127, message = "Name must be between 2 and 127 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Name must be alphanumeric and cannot contain special characters")
    @Column(name = "name", nullable = false)
    private String name;

}
