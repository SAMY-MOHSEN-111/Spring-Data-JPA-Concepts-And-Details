package com.global.hr.repository;

import com.global.hr.entity.Actor;
import com.global.hr.dto.ActorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {


//    @Query("select actor from Actor actor")
//    Page<ActorProjection> myImplementedFindAll(Pageable pageable);/*interface projection*/

    //    @Query("select new Actor(actor.id, actor.firstName, actor.lastName) from #{#entityName} actor")
    @Query(value = "select new com.global.hr.dto.ActorDTO(actor.id,actor.firstName,actor.lastName, concat(actor.firstName,' ',actor.lastName)) from #{#entityName} actor")
    Page<ActorDTO> myImplementedFindAll(Pageable pageable);/*constructor projection*/
     /*
     when it comes to projection one needs to have declared query to specify the return type
     at least with the interface projection.

     you need to use SpEL Expression to have the Constructor in the query ex:
     select new Actor(actor.id,actor.firstName,actor.lastName) from #{#entityName} actor
     */
}
