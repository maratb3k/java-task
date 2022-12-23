package com.example.demo.services.remainingLimit;

import com.example.demo.entities.RemainingLimit;

import java.util.List;

public interface RemainingLimitService {
    RemainingLimit saveRemainingLimit(RemainingLimit remainingLimit);
    RemainingLimit getRemainingLimit(long id);
    List<RemainingLimit> getRemainingLimits();
    RemainingLimit updateRemainingLimit(RemainingLimit remainingLimit);
    String deleteRemainingLimit(long id);
}
