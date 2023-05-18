package kz.bitlab.projectDto.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private int amount;
}
