package com.example.santa.inventory.mapper;

import com.example.santa.inventory.vo.InventoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {

    //*************************************************
    //******************** 창고별 재고 조회 **************
    //*************************************************

    //창고별 재고 list

    //창고 list 선택
    List<InventoryDTO> getWarehouseList();

    //창고 row 추가

    //창고 row 삭제

    //*************************************************
    //******************** 품목별 재고 조회 **************
    //*************************************************

    //품목별 재고 list
    List<InventoryDTO> readProductInventory();

}
