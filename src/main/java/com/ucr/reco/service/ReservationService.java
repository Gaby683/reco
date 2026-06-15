package com.ucr.reco.service;

import com.ucr.reco.model.Reservation;
import com.ucr.reco.model.Space;
import com.ucr.reco.model.Status;
import com.ucr.reco.model.User;
import com.ucr.reco.model.dto.ReservationDTO;
import com.ucr.reco.repository.ReservationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationJpaRepository reservationJpaRepository;
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private UserService userService;


    //muestra las reservaciones
    public List<Reservation> findAll() {
        return reservationJpaRepository.findAll();

    }


    //agregar
    public Reservation add(ReservationDTO reservationDTO) {

        Space space = spaceService.getById(reservationDTO.getSpaceId());
        User user = userService.getUserByEmail(reservationDTO.getUserEmail());
        Reservation reservationTemp = new Reservation();


        reservationTemp.setSpace(space);
        reservationTemp.setUser(user);
        reservationTemp.setStartDate(reservationDTO.getStartDate());
        reservationTemp.setEndDate(reservationDTO.getEndDate());
        reservationTemp.setStatus(Status.PENDING);

        return reservationJpaRepository.save(reservationTemp);
    }


}//fin class

