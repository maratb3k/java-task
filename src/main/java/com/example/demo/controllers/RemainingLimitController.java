package com.example.demo.controllers;

import com.example.demo.entities.RemainingLimit;
import com.example.demo.services.remainingLimit.RemainingLimitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/remainingLimits/")
public class RemainingLimitController {
    private RemainingLimitServiceImpl remainingLimitService;

    @Autowired
    public RemainingLimitController(RemainingLimitServiceImpl remainingLimitService) {
        this.remainingLimitService = remainingLimitService;
    }

    @PostMapping(path = "/remainingLimit")
    public RemainingLimit addRemainingLimit(@RequestBody RemainingLimit remainingLimit) {
        return remainingLimitService.saveRemainingLimit(remainingLimit);
    }

    @GetMapping
    public List<RemainingLimit> findAllRemainingLimits() {
        return remainingLimitService.getRemainingLimits();
    }

    @GetMapping(path = "/remainingLimit/{id}")
    public RemainingLimit findRemainingLimitByID(@PathVariable long id) {
        return remainingLimitService.getRemainingLimit(id);
    }

    @PutMapping(path = "/{id}/")
    public RemainingLimit updateRemainingLimit(@PathVariable long id, @RequestBody RemainingLimit remainingLimit) {
        remainingLimit.setId(id);
        return remainingLimitService.updateRemainingLimit(remainingLimit);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRemainingLimit(@PathVariable long id) {
        return remainingLimitService.deleteRemainingLimit(id);
    }
}
