package com.example.demo.services.maxLimit;

import com.example.demo.entities.MaxLimit;
import java.util.List;

public interface MaxLimitService {
    MaxLimit saveMaxLimit(MaxLimit maxLimit);
    MaxLimit getMaxLimit(long id);
    List<MaxLimit> getMaxLimits();
    MaxLimit updateMaxLimit(MaxLimit maxLimit);
    String deleteMaxLimit(long id);
}
