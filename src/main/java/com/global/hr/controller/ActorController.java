package com.global.hr.controller;

import com.global.hr.entity.Actor;
import com.global.hr.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/actors")
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(value = "pageNumber") int pageNumber,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "sortColumn", required = false) String sortColumn,
            @RequestParam(value = "isDesc", required = false) Boolean isDesc
    ) {
        return ResponseEntity.ok(actorService.findAll(pageNumber, pageSize, isDesc, sortColumn));
    }

    @GetMapping(path = "compound")
    public ResponseEntity<?> findCompound(
            @RequestParam(value = "sortCol", required = false) List<String> sortColumns
    ) {
        return ResponseEntity.ok(actorService.findAllSortCompound(sortColumns));
    }

    @GetMapping(path = "implemented")
    public ResponseEntity<?> findAllImplemented(
            @RequestParam(value = "pageNum", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ) {
        return new ResponseEntity<>(actorService.myImplementedFindAll(pageNumber,pageSize), HttpStatus.OK);
    }
}
