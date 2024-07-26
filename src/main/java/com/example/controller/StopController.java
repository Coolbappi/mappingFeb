package com.example.controller;

import com.example.dto.StopDto;
import com.example.service.StopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/stop")
public class StopController {
    private StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }
    @PostMapping
    public ResponseEntity<StopDto> createStop(@RequestBody StopDto stopDto){
        StopDto dtos = stopService.createStop(stopDto);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
}
