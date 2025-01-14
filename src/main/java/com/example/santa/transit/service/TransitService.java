package com.example.santa.transit.service;

import com.example.santa.transit.mapper.TransitMapper;
import com.example.santa.transit.vo.TransitDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransitService {
    private final TransitMapper transitMapper;

    public List<TransitDTO> findAllTransit() {
        List <TransitDTO> transits = transitMapper.findAllTransit();
        System.out.println("transits >>>>>>>>>>>> " + transits);
        return transits;
    }

    public void updateTransit(List<Integer> transitIds) {
        transitMapper.updateTransitStatus(transitIds);
    }

    public void rejectTransit(List<Integer> transitIds){
        transitMapper.updateTransitStatusRejection(transitIds);
    }

    public List<TransitDTO> getCoordinatesForTransits(List<Integer> transitIds) {
        return transitMapper.getCoordinatesForTransit(transitIds);
    }
}
