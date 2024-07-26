package com.example.service;

import com.example.dto.BusDto;
import com.example.entity.Bus;
import com.example.entity.BusStop;

import java.util.Optional;

public interface BusService {
    BusDto createBus(BusDto busDto);

    Bus getBusId(long busId);

    void deleteBus(long busId);

    BusDto updateBus(BusDto busDto, long busId);
}
