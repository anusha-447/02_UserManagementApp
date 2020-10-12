package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

}
