package com.example.santa.outgoing.controller;

import com.example.santa.outgoing.service.OutgoingService;
import com.example.santa.outgoing.vo.OutgoingDTO;
import com.example.santa.transit.vo.TransitDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/outgoing")
@RequiredArgsConstructor
@Log4j2
public class OutgoingController {

    private final OutgoingService outgoingService;

    @GetMapping("/outgoingRead")
    public String readOutgoing(Model model) {
        List<OutgoingDTO> list = outgoingService.findAllOutgoing();
        System.out.println("list >>>>> " + list);
        model.addAttribute("list", list);

        return "/outgoing/outgoingRead";
    }

    @PostMapping("readProduct")
    @ResponseBody
    public List<OutgoingDTO> readProduct(@RequestBody OutgoingDTO outgoingDTO, Model model) {
        System.out.println("=========================OKAY READPRODUCT===============");
        List<OutgoingDTO> list = outgoingService.findOutgoingByBranchName(outgoingDTO.getBranchName());
        System.out.println("=============list========" + list);
        return list;
    }

    @PostMapping("readCategory")
    @ResponseBody
    public List<OutgoingDTO> readCategory(@RequestBody OutgoingDTO outgoingDTO, Model model) {
        System.out.println("=========================OKAY READ CATEGORY===============");
        List<OutgoingDTO> list = outgoingService.findOutgoingByCategory(outgoingDTO.getProductCategory());
        System.out.println("=============list========" + list);
        return list;

    }

    @GetMapping("/outgoingApprove")
    public String readOutgoingApprove(Model model) {
        List<OutgoingDTO> list = outgoingService.findAllOutgoing();
        System.out.println("list >>>>> " + list);
        model.addAttribute("list", list);

        return "/outgoing/outgoingApprove";
    }

    @PostMapping("/approve")
    public ResponseEntity<?> approveOutgoing(@RequestBody Map<String, List<Integer>> request) {
        List<Integer> outgoingIds = request.get("outgoingIds");

        if (outgoingIds == null || outgoingIds.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "선택된 출고 항목이 없습니다."));
        }

        try {
            outgoingService.approveOutgoing(outgoingIds);
            return ResponseEntity.ok(Map.of("success", true));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", e.getMessage()));
        }
    }

    @PostMapping("/reject")
    public ResponseEntity<?> rejectionOutgoing(@RequestBody Map<String, List<Integer>> request) {
        List<Integer> outgoingIds = request.get("outgoingIds");

        if (outgoingIds == null || outgoingIds.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "선택된 출고 항목이 없습니다."));
        }

        try {
            outgoingService.rejectOutgoing(outgoingIds);
            return ResponseEntity.ok(Map.of("success", true));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "message", e.getMessage()));
        }
    }


}
