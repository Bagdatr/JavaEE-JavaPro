package kz.rakhimov.buildings_rest_ajax.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="serviceCompanies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceCompany extends BaseEntity{
    private String name;
}
