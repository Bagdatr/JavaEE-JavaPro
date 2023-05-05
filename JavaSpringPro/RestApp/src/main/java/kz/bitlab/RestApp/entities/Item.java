package kz.bitlab.RestApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="items")
@Getter
@Setter
public class Item extends BaseEntity{
    private String name;
    private int price;
    private int amount;
}
