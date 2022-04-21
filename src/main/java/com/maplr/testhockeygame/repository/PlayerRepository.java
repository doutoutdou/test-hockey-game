package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {
    Optional<PlayerEntity> findByNumber(long number);
}
