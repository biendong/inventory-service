package vn.nashtech.inventory.inventory.api.mapper;

import org.springframework.stereotype.Component;
import vn.nashtech.inventory.inventory.api.dto.InventoryResponse;
import vn.nashtech.inventory.inventory.database.entity.InventoryEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class InventoryMapper {
    public List<InventoryResponse> mapToListRS(List<InventoryEntity> goodEntities) {
        if (goodEntities == null || goodEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return goodEntities.stream().map(this::mapToRS).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public InventoryResponse mapToRS(InventoryEntity inventory) {
        if (inventory == null) {
            return null;
        }
        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setId(inventory.getId());
        inventoryResponse.setProductId(inventory.getProductId());
        inventoryResponse.setCostPrice(inventory.getCostPrice());
        inventoryResponse.setPrice(inventory.getPrice());
        inventoryResponse.setType(inventory.getType());
        inventoryResponse.setWholesalePrice(inventory.getWholesalePrice());
        return inventoryResponse;
    }
}
