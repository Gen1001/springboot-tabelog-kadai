package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Reservation;
import com.example.nagoyameshi.form.ReservationRegisterForm;
import com.example.nagoyameshi.repository.ReservationRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		
		reservation.setRestaurant(reservationRegisterForm.getRestaurantId());
		reservation.setUser(reservationRegisterForm.getUserId());
		reservation.setReservationDate(reservationRegisterForm.getReservationDate());
		reservation.setReservationTime(reservationRegisterForm.getReservationTime());
		reservation.setReservationNumber(reservationRegisterForm.getReservationNumber());
		
		reservationRepository.save(reservation);
	}
}
