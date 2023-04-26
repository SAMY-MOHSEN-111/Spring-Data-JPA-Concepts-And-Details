package com.global.hr.repository;

import com.global.hr.entity.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    @Query("select actor from Actor actor")
    Page<Actor> myImplementedFindAll(Pageable pageable);
}
