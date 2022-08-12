package vn.nashtech.inventory.inventory.api.dto;

import lombok.Data;
import vn.nashtech.inventory.inventory.database.model.TypeInventory;

@Data
public class InventoryRequest {
    private Long productId;
    private TypeInventory type;
    private Double costPrice;
    private Double price;
    private Double wholesalePrice;
}
