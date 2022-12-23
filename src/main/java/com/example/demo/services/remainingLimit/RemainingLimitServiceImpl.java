package com.example.demo.services.remainingLimit;

import com.example.demo.entities.RemainingLimit;
import com.example.demo.repositories.RemainingLimitRepository;
import com.example.demo.services.remainingLimit.RemainingLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemainingLimitServiceImpl implements RemainingLimitService {

    private final RemainingLimitRepository remainingLimitRepository;

    @Autowired
    public RemainingLimitServiceImpl(RemainingLimitRepository remainingLimitRepository) {
        this.remainingLimitRepository = remainingLimitRepository;
    }


    @Override
    public RemainingLimit saveRemainingLimit(RemainingLimit remainingLimit) {
        return remainingLimitRepository.save(remainingLimit);
    }

    @Override
    public RemainingLimit getRemainingLimit(long id) {
        return remainingLimitRepository.findById(id).orElse(null);
    }

    @Override
    public List<RemainingLimit> getRemainingLimits() {
        return remainingLimitRepository.findAll();
    }

    @Override
    public RemainingLimit updateRemainingLimit(RemainingLimit remainingLimit) {
        return remainingLimitRepository.save(remainingLimit);
    }

    @Override
    public String deleteRemainingLimit(long id) {
        remainingLimitRepository.deleteById(id);
        return "RemainingLimit #" + id + " deleted";
    }
}
