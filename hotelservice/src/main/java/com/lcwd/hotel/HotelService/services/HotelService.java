package com.lcwd.hotel.HotelService.services;

import com.lcwd.hotel.HotelService.entites.Hotel;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);




    void delete(String hotelId);
}
