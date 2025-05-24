package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework. stereotype.Service;
import java.util.*;

@Service
public class ReservationService
{
    @Autowired
    private ReservationRepository reservationRepository;

    
    public List<Reservation> getAllReservation()
    {
        return reservationRepository.findAll();
    } 

}