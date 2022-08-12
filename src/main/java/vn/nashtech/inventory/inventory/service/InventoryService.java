package vn.nashtech.inventory.inventory.service;

import vn.nashtech.inventory.inventory.api.dto.InventoryRequest;
import vn.nashtech.inventory.inventory.database.entity.InventoryEntity;

import java.util.List;

public interface InventoryService {
    void create(InventoryRequest req);
    InventoryEntity updateInventory(Long id, InventoryRequest req);
    List<InventoryEntity> listInventories();
    void deleteInventory(Long id);
}
