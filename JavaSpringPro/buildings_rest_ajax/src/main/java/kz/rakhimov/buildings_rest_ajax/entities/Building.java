package kz.rakhimov.buildings_rest_ajax.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="buildings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Building extends BaseEntity {
    private String name;
    private String location;
    private int floors;
    private String cadastralNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    private Developer developer;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ServiceCompany> serviceCompanies;
}
