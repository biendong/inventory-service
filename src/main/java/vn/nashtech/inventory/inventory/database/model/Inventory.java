package vn.nashtech.inventory.inventory.database.model;

import lombok.Data;

@Data
public class Inventory {
    private Long id;
    private Long productId;
    private TypeInventory type;
    private Double costPrice;
    private Double price;
    private Double wholesalePrice;
}
