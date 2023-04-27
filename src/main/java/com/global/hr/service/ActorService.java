package com.global.hr.service;

import com.global.hr.entity.Actor;
import com.global.hr.dto.ActorDTO;
import com.global.hr.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.data.domain.Sort.Order;
import static org.springframework.data.domain.Sort.by;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Page<Actor> findAll(int pageNumber, int pageSize, Boolean isDesc, String sortColumn) {
        sortColumn = isNull(sortColumn) ? "id" : sortColumn;
        Sort sort = by(!isNull(isDesc) ? DESC : ASC, sortColumn);
        Pageable page = PageRequest.of(pageNumber, pageSize, sort);
        return actorRepository.findAll(page);
    }

    public List<Actor> findAllSortCompound(List<String> sortColumns) {
        List<Order> orders = new ArrayList<>();
        if (sortColumns != null) {
            for (String col : sortColumns) {
                orders.add(new Order(ASC, col));
            }
        }
        return actorRepository.findAll(Sort.by(orders));
    }

//    public Page<ActorProjection> myImplementedFindAll(Integer pageNumber, Integer pageSize) { // interface projection
//        pageNumber = isNull(pageNumber) ? 0 : pageNumber;
//        pageSize = isNull(pageSize) ? (int) actorRepository.count() : pageSize;
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        return actorRepository.myImplementedFindAll(pageable);
//    }

    public Page<ActorDTO> myImplementedFindAll(Integer pageNumber, Integer pageSize) { // constructor projection
        pageNumber = isNull(pageNumber) ? 0 : pageNumber;
        pageSize = isNull(pageSize) ? (int) actorRepository.count() : pageSize;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return actorRepository.myImplementedFindAll(pageable);
    }
}
