package kz.bitlab.CrmSystem_SprintTask_6_1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="user_name")
    private String userName;
    @Column(name="course_name")
    private String courseName;
    @Column(name="commentary")
    private String commentary;
    @Column(name="phone")
    private String phone;
    @Column(name="handled")
    private boolean handled;
}
