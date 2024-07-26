package com.example.service;

import com.example.dto.BusDto;
import com.example.entity.Bus;
import com.example.entity.BusStop;
import com.example.repository.BusRepository;
import com.example.repository.BusStopRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;



@Service
public class BusServiceImpl implements BusService {
    private BusRepository busRepository;
    private BusStopRepository busStopRepository;

    public BusServiceImpl(BusRepository busRepository, BusStopRepository busStopRepository) {
        this.busRepository = busRepository;
        this.busStopRepository = busStopRepository;
    }

    @Override
    public BusDto createBus(BusDto busDto) {
        Bus bus = mapToEntity(busDto);
        Bus save = busRepository.save(bus);
        BusDto busDto1 = mapToDto(save);
        return busDto1;
    }

    @Override
    public Bus getBusId(long busId) {
        Bus byId = busRepository.findById(busId).get();
        return byId;
    }

    @Override
    @Transactional
    public void  deleteBus(long busId) {
        busStopRepository.deleteByBusId(busId);
        busRepository.deleteById(busId);
    }

    @Override
    public BusDto updateBus(BusDto busDto, long busId) {

        return null;
    }

    Bus mapToEntity(BusDto dto){
        Bus entity = new Bus();
        entity.setName(dto.getName());
        return entity;
    }
    BusDto mapToDto(Bus entity){
        BusDto dto = new BusDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
