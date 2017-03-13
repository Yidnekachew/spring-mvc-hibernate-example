package com.spring.dynamic.web.dao;

import com.spring.dynamic.web.model.Hotel;

import java.util.List;

public interface HotelDao {

    public void save(Hotel hotel);

    public void update(Hotel hotel);

    public void delete(Hotel hotel);

    public Hotel get(Long id);

    public List<Hotel> findAll();

}
