package com.example.service;

import com.example.dto.StopDto;
import com.example.entity.Stop;

import java.util.Optional;

public interface StopService {
    StopDto createStop(StopDto stopDto);

    Stop getStopId(long stopId);
}
