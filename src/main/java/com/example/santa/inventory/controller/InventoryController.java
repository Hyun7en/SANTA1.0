package com.example.santa.inventory.controller;

import com.example.santa.inventory.service.InventoryService;
import com.example.santa.inventory.vo.InventoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    //*************************************************
    //******************** 창고별 재고 조회 **************
    //*************************************************

    //창고별 재고 조회
    @GetMapping("warehouseRead")
    public String warehouseManagement() {

        return "inventory/warehouseRead";
    }

    //창고별 재고 list
    @GetMapping("readInventory")
    @ResponseBody
    public List<InventoryDTO> readInventory() {
        List<InventoryDTO> list = inventoryService.readInventory();
        System.out.println("======= 창고별 재고 list =======");
        System.out.println(list);
        return list;
    }

    //창고 list 선택
    @GetMapping("warehouseList")
    @ResponseBody
    public List<InventoryDTO> getWarehouseList() {
        List<InventoryDTO> list = inventoryService.getWarehouseList();
        System.out.println("====== 창고 list ======");
        System.out.println(list);
        return list;
    }

    //창고 column 추가
    @PostMapping("addWarehouse")
    @ResponseBody
    public List<InventoryDTO> addWarehouse(@RequestBody  InventoryDTO inventoryDTO ) {
        int warehouseId = inventoryDTO.getWarehouseId();

        System.out.println("warehouseId : " + warehouseId);
        List<InventoryDTO> list = inventoryService.addWarehouse(warehouseId);
        System.out.println("========= 창고 column 추가 =========");
        System.out.println(list);

        return list;
    }

    //창고 column 삭제
    
    //*************************************************
    //******************** 품목별 재고 조회 **************
    //*************************************************

    //품목별 재고 조회
    @GetMapping("categoryRead")
    public String categoryManagement() {

        return "inventory/categoryRead";
    }

    //품목별 재고 list
    @GetMapping("readProductInventory")
    @ResponseBody
    public List<InventoryDTO> readProductInventory() {
        List<InventoryDTO> list = inventoryService.readProductInventory();
        System.out.println("========= 품목별 재고 list =========");
        System.out.println(list);

        return list;
    }

}
