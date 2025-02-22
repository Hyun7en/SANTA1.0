package com.example.santa.inventory.vo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryVO {

    private int inventoryId;
    private int warehouseId;
    private int productId;
    private int quantity;
    private Date lastUpdated;

}
