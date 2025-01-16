package com.example.santa.transit.service;

import com.example.santa.transit.mapper.TransitMapper;
import com.example.santa.transit.vo.TransitDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransitService implements TransitServiceInterface {
    private final TransitMapper transitMapper;

    @Override
    public List<TransitDTO> findAllTransit() {
        List <TransitDTO> transits = transitMapper.findAllTransit();
        System.out.println("transits >>>>>>>>>>>> " + transits);
        return transits;
    }

    @Override
    public void updateTransit(List<Integer> transitIds) {
        transitMapper.updateTransitStatus(transitIds);
    }

    @Override
    public void rejectTransit(List<Integer> transitIds){
        transitMapper.updateTransitStatusRejection(transitIds);
    }

    @Override
    public List<TransitDTO> getCoordinatesForTransits(List<Integer> transitIds) {
        return transitMapper.getCoordinatesForTransit(transitIds);
    }
}
