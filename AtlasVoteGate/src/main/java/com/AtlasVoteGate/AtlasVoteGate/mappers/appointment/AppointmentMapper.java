package com.AtlasVoteGate.AtlasVoteGate.mappers.appointment;

import com.AtlasVoteGate.AtlasVoteGate.dto.AppointmentDTO;
import com.AtlasVoteGate.AtlasVoteGate.model.Appointment;

public interface AppointmentMapper {
    AppointmentDTO fromAppointment(Appointment appointment);
    Appointment fromAppointmentDTO(AppointmentDTO appointmentDTO);
}
