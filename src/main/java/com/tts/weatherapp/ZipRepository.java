package com.tts.weatherapp;

import java.util.List;

//import com.tts.weatherapp.ZipCodes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipRepository extends CrudRepository<ZipCodes, Long> {
    ZipCodes findByZip(String zipCode);

    public List<ZipCodes> findTop10ByOrderByDateDesc();
}

// select * from zipcodes orderby date desc;