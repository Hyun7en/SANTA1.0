package com.example.santa.transit.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
 //화면에 넘겨줄 때 json 날짜 데이터 포맷팅 해줌
public class TransitDTO {

    private int transitId;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
   private LocalDateTime transitDate;

   public String getFormattedTransitDate() {
      if (transitDate != null) {
         return transitDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      }
      return "";
   }

   private int transitQuantity;
   private String transitStatus;
   private String warehouseName;
   private String warehouseLocation;
   private String branchName;
   private String branchLocation;

   private double warehouseLatitude;
   private double warehouseLongitude;
   private double branchLatitude;
   private double branchLongitude;

   private String totalTime; // 총 소요 시간
   private String totalCost; // 총 비용
   private double totalDistance; // 총 거리

}
