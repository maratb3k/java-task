package com.example.demo.controllers;

import com.example.demo.entities.MaxLimit;
import com.example.demo.services.maxLimit.MaxLimitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maxLimits/")
public class MaxLimitController {
    private MaxLimitServiceImpl maxLimitService;

    @Autowired
    public MaxLimitController(MaxLimitServiceImpl maxLimitService) {
        this.maxLimitService = maxLimitService;
    }

    @PostMapping(path = "/maxLimit")
    public MaxLimit addMaxLimit(@RequestBody MaxLimit maxLimit) {
        return maxLimitService.saveMaxLimit(maxLimit);
    }

    @GetMapping
    public List<MaxLimit> findAllMaxLimits() {
        return maxLimitService.getMaxLimits();
    }

    @GetMapping(path = "/maxLimit/{id}")
    public MaxLimit findMaxLimitByID(@PathVariable long id) {
        return maxLimitService.getMaxLimit(id);
    }

    @PutMapping(path = "/{id}/")
    public MaxLimit updateMaxLimit(@PathVariable long id, @RequestBody MaxLimit maxLimit) {
        maxLimit.setId(id);
        return maxLimitService.updateMaxLimit(maxLimit);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteMaxLimit(@PathVariable long id) {
        return maxLimitService.deleteMaxLimit(id);
    }
}
