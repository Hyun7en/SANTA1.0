package com.example.santa.outgoing.mapper;

import com.example.santa.outgoing.vo.OutgoingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OutgoingMapper {
    // 1. 전체 출고 조회
    List<OutgoingDTO> findAllOutgoing();

    // 2. 지점별 출고 조회
    List<OutgoingDTO> findOutgoingByBranchName(@Param("branchName") String branchName);

    // 3. 카테고리별 출고 조회
    List<OutgoingDTO> findOutgoingByCategory(@Param("category") String category);

    // 4. 날짜별 출고 조회
    List<OutgoingDTO> findOutgoingByDate(@Param("startDate") String startDate,
                                         @Param("endDate") String endDate);

    // 5. 출고 승인시 상태(대기->완료) 업데이트
    void updateOutgoingStatus(@Param("outgoingIds") List<Integer> outgoingIds);

    // 5.5 출고 거절시 상태(대기->거절) 업데이트
    void updateOutgoingStatusRejection(@Param("outgoingIds") List<Integer> outgoingIds);

    // 6. Transit 테이블에 배송 대기 데이터 추가
    void insertTransitRecords(@Param("outgoingIds") List<Integer> outgoingIds);
}

