package vn.nashtech.inventory.inventory.database.entity;

import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import vn.nashtech.inventory.inventory.database.model.Inventory;
import vn.nashtech.inventory.inventory.database.model.TypeInventory;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
@DynamicUpdate
@Setter
public class InventoryEntity extends Inventory {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {return super.getId();}

    @Column(name = "product_id")
    public Long getProductId() {return super.getProductId();}

    @Column(name = "type")
    public TypeInventory getType() {return super.getType();}

    @Column(name = "cost_price")
    public Double getCostPrice() {return super.getCostPrice();}

    @Column(name = "price")
    public Double getPrice() {return super.getPrice();}

    @Column(name = "wholesale_price")
    public Double getWholesalePrice() {return super.getWholesalePrice();}
}
