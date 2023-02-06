package com.sinchan.webautomation.services;

import com.sinchan.webautomation.entities.City;
import com.sinchan.webautomation.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();

    }
}
