package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;

import com.AtlasVoteGate.AtlasVoteGate.model.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    Appointment getAppointmentById(Long appointmentId);
    List<Appointment> findAllAppointmentsByDate(Date date);
    Appointment verifyAppointment(Long appointmentId);
    // Other appointment-related methods
}
