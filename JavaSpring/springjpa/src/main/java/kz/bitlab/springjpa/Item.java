package kz.bitlab.springjpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="items")
@Data
@AllArgsConstructor
@NoArgsConstructor //Data, AllArgs...,NoArgs - это Lombok
public class Item {
    @Id //это primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // это serial (автоинкримент)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="amount")
    private int amount;
}