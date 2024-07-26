package com.example.service;

import com.example.entity.BusStop;
import com.example.repository.BusStopRepository;
import org.springframework.stereotype.Service;

@Service
public class BusStopServiceImpl implements BusStopService{
    private BusStopRepository busStopRepository;

    public BusStopServiceImpl(BusStopRepository busStopRepository) {
        this.busStopRepository = busStopRepository;
    }

    @Override
    public BusStop allocateBusStop(BusStop busStop) {
        var savedBusStop = busStopRepository.save(busStop);
        return savedBusStop;
    }
}
