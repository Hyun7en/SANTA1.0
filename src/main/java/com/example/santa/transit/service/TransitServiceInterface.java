package com.example.santa.transit.service;

import com.example.santa.transit.vo.TransitDTO;

import java.util.List;

public interface TransitServiceInterface {
    List<TransitDTO> findAllTransit();

    void updateTransit(List<Integer> transitIds);

    void rejectTransit(List<Integer> transitIds);

    List<TransitDTO> getCoordinatesForTransits(List<Integer> transitIds);
}
