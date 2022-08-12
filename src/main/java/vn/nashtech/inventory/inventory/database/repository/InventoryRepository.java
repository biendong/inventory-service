package vn.nashtech.inventory.inventory.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.nashtech.inventory.inventory.database.entity.InventoryEntity;

@Repository
public interface InventoryRepository extends CrudRepository<InventoryEntity, Long> {
}
