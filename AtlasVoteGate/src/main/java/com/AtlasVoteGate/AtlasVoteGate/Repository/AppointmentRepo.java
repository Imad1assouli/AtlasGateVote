package com.AtlasVoteGate.AtlasVoteGate.Repository;

import com.AtlasVoteGate.AtlasVoteGate.enums.AppointmentStatus;
import com.AtlasVoteGate.AtlasVoteGate.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    List<Appointment> findByAppointmentTimeBetweenAndStatus(LocalDateTime start, LocalDateTime end, AppointmentStatus status);
}
