package com.example.santa.inventory.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {
    private int productId;
    private String productName;
    private int capacity;
    private int inventoryQuantity; // 창고별 재고들을 합친 총 재고
    private int totalInventory;
    private int warehouseId;
    private String warehouseName;
    private int warehouseQuantity; // 창고별 재고
    private String categoryName;
    private String manufacturerName;
    private int price;
//    product_id: 품목의 고유 ID
//    product_name: 품목명
//    category_name: 품목이 속한 카테고리명
//    manufacturer_name: 제조사명
//    warehouse_name: 재고가 위치한 창고명
//    quantity: 재고 수량
//    price: 품목 가격
}
