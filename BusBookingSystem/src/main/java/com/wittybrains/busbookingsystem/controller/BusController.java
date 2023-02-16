package com.wittybrains.busbookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.busbookingsystem.model.Bus;
import com.wittybrains.busbookingsystem.repository.BusRepository;

@RestController("/bus")
public class BusController {
    private final BusRepository busRepository;
    
    @Autowired
    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }
    
    @GetMapping("/searchBuses")
    public List<Bus> searchBuses(@RequestParam("source") String source,
                                 @RequestParam("destination") String destination,
                                 @RequestParam("timing") String timing) {
        return busRepository.findBySourceAndDestinationAndTiming(source, destination, timing);
    }
}
