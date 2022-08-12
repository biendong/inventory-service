package vn.nashtech.inventory.inventory.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nashtech.inventory.inventory.api.dto.InventoryRequest;
import vn.nashtech.inventory.inventory.database.entity.InventoryEntity;
import vn.nashtech.inventory.inventory.database.repository.InventoryRepository;
import vn.nashtech.inventory.inventory.service.InventoryService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    @Override
    public void create(InventoryRequest req) {
        InventoryEntity entity = new InventoryEntity();
        mapperData(entity, req);
        inventoryRepository.save(entity);
    }

    @Override
    public InventoryEntity updateInventory(Long id, InventoryRequest req) {
        InventoryEntity good = inventoryRepository.findById(id).orElse(null);
        if (good != null) {
            mapperData(good, req);
            return inventoryRepository.save(good);
        }
        return null;
    }

    @Override
    public List<InventoryEntity> listInventories() {
        Iterable<InventoryEntity> goods = inventoryRepository.findAll();
        List<InventoryEntity> res = new ArrayList<>();
        goods.forEach(res::add);
        return res;
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    private void mapperData(InventoryEntity inventory, InventoryRequest req) {
        inventory.setCostPrice(req.getCostPrice());
        inventory.setProductId(req.getProductId());
        inventory.setPrice(req.getPrice());
        inventory.setType(req.getType());
        inventory.setWholesalePrice(req.getWholesalePrice());
    }
}
