package com.example.santa.order.controller;

import com.example.santa.order.service.OrderService;
import com.example.santa.order.vo.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //*************************************************
    //******************** 주문 조회 ********************
    //*************************************************
    @GetMapping("read")
    public String status() {
        return "order/read";
    }

    //주문 조회 list
    @GetMapping("readOrder")
    @ResponseBody
    public List<OrderDTO> readOrder(){

        List<OrderDTO> list = orderService.readOrder();
        return list;
    }

    //주문 일자 검색
    @PostMapping("searchByOrderDate")
    @ResponseBody
    public List<OrderDTO> searchByOrderDate(@RequestBody Map<String, String> dateRange) {
        String startDate = dateRange.get("startDate");
        String endDate = dateRange.get("endDate");

        System.out.println("받은 날짜: " + startDate + " ~ " + endDate);

        List<OrderDTO> list = orderService.searchByOrderDate(startDate, endDate);
        return list;
    }
    
    //상품명 검색
    @PostMapping("searchByProductName")
    @ResponseBody
    public List<OrderDTO> searchByProductName(@RequestBody OrderDTO orderDTO) {

        System.out.println("상품 검색 : " + orderDTO.getProductName());

        String productName = orderDTO.getProductName().trim();

        List<OrderDTO> list = orderService.searchByProductName(productName);
        return list;
    }

    //주문 지점 검색
    @PostMapping("searchByBranchName")
    @ResponseBody
    public List<OrderDTO> searchByBranchName(@RequestBody OrderDTO orderDTO) {

        System.out.println("지점 검색 : " + orderDTO.getBranchName());

        String branchName = orderDTO.getBranchName().trim();

        List<OrderDTO> list = orderService.searchByBranchName(branchName);
        return list;
    }

    //주문 상태 검색
    @PostMapping("searchByOrderStatus")
    @ResponseBody
    public List<OrderDTO> searchByOrderStatus(@RequestBody OrderDTO orderDTO) {

        System.out.println("주문 상태 : " + orderDTO.getOrderStatus());

        String orderStatus = orderDTO.getOrderStatus().trim();

        List<OrderDTO> list = orderService.searchByOrderStatus(orderStatus);
        return list;
    }


    //*************************************************
    //******************** 주문 승인 ********************
    //*************************************************
    @GetMapping("approval")
    public String details() {
        return "order/approval";
    }

    //승인 대기 주문 list
    @GetMapping("readPendingOrders")
    @ResponseBody
    public List<OrderDTO> readPendingOrders(){
        List<OrderDTO> list = orderService.readPendingOrders();
        System.out.println("승인 대기 주문 list : " + list);

        return list;
    }

    //주문 승인/거절
    @PostMapping("updateOrderStatus")
    @ResponseBody
    public boolean updateOrderStatus(@RequestBody OrderDTO orderDTO ) {

        int orderId = orderDTO.getOrderId();
        String orderStatus = orderDTO.getOrderStatus();

        System.out.println("----- 주문 승인/거절 -----");
        System.out.println("orderId : " + orderId + " status : " + orderStatus);

        // 상태 변경 수행
        try {
            int isUpdated = orderService.updateOrderStatus(orderId, orderStatus);
            if(isUpdated > 0 ) {
                return true; // 상태 변경 성공 여부 반환
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 출력
            return false; // 실패 시 false 반환
        }

    }

    // 승인 대기 주문, 주문 일자 검색
    @PostMapping("searchByPendingOrderDate")
    @ResponseBody
    public List<OrderDTO> searchByPendingOrderDate(@RequestBody Map<String, String> dateRange) {
        String startDate = dateRange.get("startDate");
        String endDate = dateRange.get("endDate");
        System.out.println("----- 승인 대기 주문, 주문 일자 검색 -----");
        System.out.println("Date : " + startDate + " ~ " + endDate);
        List<OrderDTO> list = orderService.searchByPendingOrderDate(startDate, endDate);
        return list;
    }

    // 승인 대기 주문, 주문 상품 검색
    @PostMapping("searchByPendingProductName")
    @ResponseBody
    public List<OrderDTO> searchByPendingProductName(@RequestBody OrderDTO orderDTO) {
        String productName = orderDTO.getProductName().trim();
        System.out.println("----- 승인 대기 주문, 주문 상품 검색 -----");
        System.out.println("productName : " + productName);
        List<OrderDTO> list = orderService.searchByPendingProductName(productName);
        return list;
    }

    // 승인 대기 주문, 주문 지점 검색
    @PostMapping("searchByPendingBranchName")
    @ResponseBody
    public List<OrderDTO> searchByPendingBranchName(@RequestBody OrderDTO orderDTO) {
        String branchName = orderDTO.getBranchName().trim();
        System.out.println("----- 승인 대기 주문, 주문 지점 검색 -----");
        System.out.println("branchName : " + branchName);
        List<OrderDTO> list = orderService.searchByPendingBranchName(branchName);
        return list;
    }

//refactoring 방향성
// --> 1. 검색 통합
// --> 2. 주문 일자 검색시 DTO 쓰기
}
