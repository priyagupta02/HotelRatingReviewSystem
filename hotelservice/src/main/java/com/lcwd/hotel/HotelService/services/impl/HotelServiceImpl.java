package com.lcwd.hotel.HotelService.services.impl;

import com.lcwd.hotel.HotelService.entites.Hotel;
import com.lcwd.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.HotelService.repositories.HotelRepository;
import com.lcwd.hotel.HotelService.services.HotelService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Setter
@Service

public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        hotel.setId(UUID.randomUUID());
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found !!"));
    }
    @Override
    public void delete(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + hotelId));
        hotelRepository.delete(hotel);
    }

}
