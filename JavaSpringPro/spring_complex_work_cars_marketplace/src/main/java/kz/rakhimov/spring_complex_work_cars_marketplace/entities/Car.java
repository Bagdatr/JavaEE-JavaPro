package kz.rakhimov.spring_complex_work_cars_marketplace.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="t_cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int year;
    private int month;
    private String vin;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Brand> brands;
}
