package com.sinchan.webautomation.repositories;

import com.sinchan.webautomation.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City,Integer> {
    }
