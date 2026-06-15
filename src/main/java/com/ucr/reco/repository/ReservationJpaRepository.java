package com.ucr.reco.repository;

import com.ucr.reco.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationJpaRepository
        extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByUserEmail(String email);

    List<Reservation> findBySpaceId(Integer spaceId);

    List<Reservation> findByStartDate(LocalDateTime startDate);
}


