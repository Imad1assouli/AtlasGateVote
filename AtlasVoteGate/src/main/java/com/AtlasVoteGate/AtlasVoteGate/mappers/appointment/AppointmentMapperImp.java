package com.AtlasVoteGate.AtlasVoteGate.mappers.appointment;

import com.AtlasVoteGate.AtlasVoteGate.dto.AppointmentDTO;
import com.AtlasVoteGate.AtlasVoteGate.model.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentMapperImp implements AppointmentMapper {
    // private StageMapper mapper;
    @Override
    public AppointmentDTO fromAppointment(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        BeanUtils.copyProperties(appointment, appointmentDTO);
        // appointmentDTO.setStage(mapper.fromStage(appointment.getStage()));
        return appointmentDTO;
    }

    @Override
    public Appointment fromAppointmentDTO(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentDTO, appointment);
        // appointment.setStage(mapper.fromStageDTO(etudiantDTO.getStage()));
        return appointment;
    }
}
