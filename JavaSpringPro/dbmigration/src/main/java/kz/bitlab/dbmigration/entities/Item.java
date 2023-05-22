package kz.bitlab.dbmigration.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="items")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private int amount;
}
