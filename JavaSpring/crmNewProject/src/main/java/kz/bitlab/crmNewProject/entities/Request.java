package kz.bitlab.crmNewProject.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phone;
    private String comment;
    private boolean handle;
    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;
}
