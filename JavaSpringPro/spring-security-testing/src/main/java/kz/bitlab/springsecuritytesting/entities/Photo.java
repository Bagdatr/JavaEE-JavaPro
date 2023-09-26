package kz.bitlab.springsecuritytesting.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="photos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Photo extends BaseEntity{
    private String name;

}
