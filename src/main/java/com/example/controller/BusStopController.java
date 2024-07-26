package com.example.controller;

import com.example.entity.Bus;
import com.example.entity.BusStop;
import com.example.entity.Stop;
import com.example.service.BusService;
import com.example.service.BusStopService;
import com.example.service.StopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/app/v1/busStop")
public class BusStopController {
    private BusService busService;
    private StopService stopService;
    private BusStopService busStopService;

    public BusStopController(BusService busService, StopService stopService, BusStopService busStopService) {
        this.busService = busService;
        this.stopService = stopService;
        this.busStopService = busStopService;
    }

    @PostMapping
    public ResponseEntity<BusStop> allocateBusStop(
            @RequestBody BusStop busStop,
            @RequestParam long busId,
            @RequestParam long stopId
    ) {
        Bus bus = busService.getBusId(busId);
        Stop stop = stopService.getStopId(stopId);
        busStop.setBus(bus);
        busStop.setStop(stop);
        var savedBusStop = busStopService.allocateBusStop(busStop);
        return new ResponseEntity<>(savedBusStop, HttpStatus.CREATED);
    }
}
