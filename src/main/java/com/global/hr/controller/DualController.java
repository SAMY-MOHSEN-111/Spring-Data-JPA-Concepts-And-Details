package com.global.hr.controller;

import com.global.hr.service.DualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/statistics")
public class DualController {
    private final DualService dualService;

    @Autowired
    public DualController(DualService dualService) {
        this.dualService = dualService;
    }

    @GetMapping("/native") // naming is not meant to be in production
    public ResponseEntity<?> getHrStatisticsNative(){
        return ResponseEntity.ok(dualService.getHrStatisticsNative());
    }

    @GetMapping("/jpql")
    public ResponseEntity<?> getHrStatisticsJPQL(){ // naming is not meant to be in production
        return ResponseEntity.ok(dualService.getHrStatisticsJPQL());
    }
}
