package com.example.service;

import com.example.dto.BusDto;
import com.example.dto.StopDto;
import com.example.entity.Bus;
import com.example.entity.Stop;
import com.example.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StopServiceImpl implements StopService{
    private StopRepository stopRepository;
    public StopServiceImpl(StopRepository stopRepository){
        this.stopRepository = stopRepository;
    }
    @Override
    public StopDto createStop(StopDto stopDto) {
        Stop stop = mapToEntity(stopDto);
        Stop savedEntity = stopRepository.save(stop);
        StopDto stopDto1 = mapToDto(savedEntity);
        return stopDto1;
    }

    @Override
    public Stop getStopId(long stopId) {
        Stop byId = stopRepository.findById(stopId).get();
        return byId;
    }

    Stop mapToEntity(StopDto dto){
        Stop entity = new Stop();
        entity.setStopName(dto.getStopName());
        return entity;
    }
    StopDto mapToDto(Stop entity){
        StopDto dto = new StopDto();
        dto.setId(entity.getId());
        dto.setStopName(entity.getStopName());
        return dto;
    }
}
