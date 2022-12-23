package com.example.demo.services.maxLimit;

import com.example.demo.entities.MaxLimit;
import com.example.demo.repositories.MaxLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaxLimitServiceImpl implements MaxLimitService{

    private final MaxLimitRepository maxLimitRepository;

    @Autowired
    public MaxLimitServiceImpl(MaxLimitRepository maxLimitRepository) {
        this.maxLimitRepository = maxLimitRepository;
    }

    @Override
    public MaxLimit saveMaxLimit(MaxLimit maxLimit) {
        return maxLimitRepository.save(maxLimit);
    }

    @Override
    public MaxLimit getMaxLimit(long id) {
        return maxLimitRepository.findById(id).orElse(null);
    }

    @Override
    public List<MaxLimit> getMaxLimits() {
        return maxLimitRepository.findAll();
    }

    @Override
    public MaxLimit updateMaxLimit(MaxLimit maxLimit) {
        return maxLimitRepository.save(maxLimit);
    }

    @Override
    public String deleteMaxLimit(long id) {
        maxLimitRepository.deleteById(id);
        return "MaxLimit #" + id + " deleted";
    }
}
