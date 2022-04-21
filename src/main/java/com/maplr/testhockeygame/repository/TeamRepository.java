package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<TeamEntity, Long> {
    Optional<TeamEntity> findByYear(long year);
}
