package com.global.hr.service;

import com.global.hr.repository.DualRepository;
import com.global.hr.repository.HRStatisticsProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DualService {
    private final DualRepository dualRepository;

    @Autowired
    public DualService(DualRepository dualRepository) {
        this.dualRepository = dualRepository;
    }

    public HRStatisticsProjection getHrStatisticsNative() {
        return dualRepository.getHRStatisticsNative();
    }

    public HRStatisticsProjection getHrStatisticsJPQL() {
        return dualRepository.getHrStatisticsJPQL();
    }
}
