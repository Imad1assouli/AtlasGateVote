package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;

import com.AtlasVoteGate.AtlasVoteGate.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    Appointment save (Appointment appointment);

    Appointment getAppointment (Long idappointment);

    void delete (Long idappointment);

    List<Appointment> getAllAppointments();

    void update (Long id ,Appointment newappointment);

    void cancel (Long idappointment);

    void verify (Long idappointment);

    List<Appointment> getAppointmentsForToday();

    List<Appointment> getAppointmentsForDate(LocalDate date);
}
