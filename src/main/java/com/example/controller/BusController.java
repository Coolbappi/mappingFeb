package com.example.controller;

import com.example.dto.BusDto;
import com.example.service.BusService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1/bus")
public class BusController {
    private BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto busDto) {
        BusDto dtos = busService.createBus(busDto);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBus(@RequestParam long busId) {
        busService.deleteBus(busId);
        return new ResponseEntity<>("Deleted Bus : " + busId, HttpStatus.NO_CONTENT);
    }
//    @PutMapping
//    public ResponseEntity<BusDto> updateBus(@RequestBody BusDto busDto, long busId){
//        busService.updateBus(busDto, busId);
//    }
}
