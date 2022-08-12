package vn.nashtech.inventory.inventory.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.nashtech.inventory.inventory.api.dto.InventoryRequest;
import vn.nashtech.inventory.inventory.api.dto.InventoryResponse;
import vn.nashtech.inventory.inventory.api.mapper.InventoryMapper;
import vn.nashtech.inventory.inventory.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    private final InventoryMapper inventoryMapper;

    @Autowired
    public InventoryController(InventoryService inventoryService, InventoryMapper inventoryMapper) {
        this.inventoryService = inventoryService;
        this.inventoryMapper = inventoryMapper;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody InventoryRequest request){
        inventoryService.create(request);
        return ResponseEntity.ok("success");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody InventoryRequest request, @PathVariable(value = "id") String id) {
        InventoryResponse response = inventoryMapper.mapToRS(inventoryService.updateInventory(Long.parseLong(id), request));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
        inventoryService.deleteInventory(Long.parseLong(id));
        return ResponseEntity.ok("success");
    }

    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        List<InventoryResponse> response = inventoryMapper.mapToListRS(inventoryService.listInventories());
        return ResponseEntity.ok(response);
    }
}
