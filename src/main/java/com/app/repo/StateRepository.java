package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {

}
