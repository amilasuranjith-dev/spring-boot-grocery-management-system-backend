package edu.icet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String id;
    private String description;
    private String packSize;
    private Double unitPrice;
    private Integer qty;
}
