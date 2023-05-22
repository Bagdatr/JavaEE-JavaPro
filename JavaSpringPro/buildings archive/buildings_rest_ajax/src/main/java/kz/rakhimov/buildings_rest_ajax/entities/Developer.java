package kz.rakhimov.buildings_rest_ajax.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="developers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Developer extends BaseEntity{
    private String name;
    private int experience;
    private int assets;
}
