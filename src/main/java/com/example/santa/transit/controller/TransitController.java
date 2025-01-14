package com.example.santa.transit.controller;

import com.example.santa.transit.service.TransitService;
import com.example.santa.transit.vo.TransitDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/transit")
@RequiredArgsConstructor
@Log4j2
public class TransitController {

    private final TransitService transitService;

    @Value("${tmap.api.key}")
    private String tmapApiKey;

//    @GetMapping("/transit/mapOptimization")
//    @ResponseBody
//    public List<TransitDTO> mapOptimization() {
//        List<TransitDTO> list = new ArrayList<>();
//        list.add(new TransitDTO());
//        return list;
//    }

//    @GetMapping("/mapOptimization")
//    public String getMapPage(Model model) {
//        model.addAttribute("tmapApiKey", tmapApiKey);
//        System.out.println("tmapKey >>>>>>>> " + tmapApiKey);
//        return "/transit/mapOptimization";
//    }


    @GetMapping("/transitRead")
    public String readTransit(Model model) {
        List<TransitDTO> list = transitService.findAllTransit();
        System.out.println("list >>>>> " + list);
        model.addAttribute("list", list);

        return "/transit/transitRead";
    }

    @GetMapping("/transitApprove")
    public String readTransitApprove(Model model) {
        List<TransitDTO> list = transitService.findAllTransit();
        System.out.println("list >>>>> " + list);
        model.addAttribute("list", list);

        return "/transit/transitApprove";
    }

    @RestController
    @RequestMapping("/map")
    public class MapController {

        private final String KAKAO_API_KEY = "YOUR_KAKAO_REST_API_KEY"; // 카카오 REST API 키

        @PostMapping("/directions")
        public ResponseEntity<String> getDirections(@RequestBody Map<String, Object> requestData) {
            String apiUrl = "https://apis-navi.kakaomobility.com/v1/waypoints/directions";

            try {
                // HTTP 요청 설정
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("Authorization", "KakaoAK " + KAKAO_API_KEY);

                HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestData, headers);

                // RestTemplate으로 API 호출
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

                return ResponseEntity.ok(response.getBody());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
            }
        }
    }

    // Transit Status Update
    @PostMapping("/approve")
    public ResponseEntity<?> approveTransit(@RequestBody Map<String, List<Integer>> request) {
        List<Integer> transitIds = request.get("transitIds");

        if (transitIds == null || transitIds.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "선택된 출고 항목이 없습니다."));
        }
        try {
            transitService.updateTransit(transitIds);
            return ResponseEntity.ok(Map.of("success", true));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());

        }
    }

    // Transit Status Update
    @PostMapping("/reject")
    public ResponseEntity<?> rejectionTransit(@RequestBody Map<String, List<Integer>> request) {
        List<Integer> transitIds = request.get("transitIds");

        if (transitIds == null || transitIds.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "선택된 출고 항목이 없습니다."));
        }
        try {
            transitService.rejectTransit(transitIds);
            return ResponseEntity.ok(Map.of("success", true));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());

        }
    }

    // 경유지 최적화 ====================================
    // ===============================================
//    @PostMapping("/mapOptimization")
//    public Map<String, Object> calculateRoute(@RequestBody Map<String, List<Integer>> request, Model model) {
//        model.addAttribute("tmapApiKey", tmapApiKey);
//        List<Integer> transitIds = request.get("transitIds");
//        Map<String, Object> response = new HashMap<>();
//
//        transitService.getCoordinatesForTransits(transitIds);
//        transitService.getCoordinatesForTransits()
//
//
//        try {
//            // 경유지 최적화 결과 계산
//            List<?> result = transitService.getCoordinatesForTransits(transitIds);
//            response.put("success", true);
//            response.put("totalTime", result.getTotalTime());
//            response.put("totalCost", result.getTotalCost());
//        } catch (Exception e) {
//            response.put("success", false);
//            response.put("message", e.getMessage());
//        }
//
//        //        return "/transit/mapOptimization";
//        return response;
//    }

    @PostMapping("/mapOptimization")
    public List<TransitDTO> optimizeRoute(@RequestBody List<Integer> transitIds) {
        return transitService.getCoordinatesForTransits(transitIds);
    }


}
