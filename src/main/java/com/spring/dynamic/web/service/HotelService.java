package com.spring.dynamic.web.service;

import com.spring.dynamic.web.dao.impl.HotelDaoImpl;
import com.spring.dynamic.web.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelDaoImpl hotelDaoImpl;

    @Transactional(readOnly = true)
    public Hotel get(Long id) {
        return hotelDaoImpl.get(id);
    }

    @Transactional
    public void delete(Hotel hotel) {
        hotelDaoImpl.delete(hotel);
    }

    @Transactional(readOnly = true)
    public List<Hotel> findAll() {
        return hotelDaoImpl.findAll();
    }

    @Transactional
    public void save(Hotel hotel) {
        hotelDaoImpl.save(hotel);
    }
}
