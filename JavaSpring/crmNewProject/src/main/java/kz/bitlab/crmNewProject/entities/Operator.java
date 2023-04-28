package kz.bitlab.crmNewProject.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_operators")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String department;
}
