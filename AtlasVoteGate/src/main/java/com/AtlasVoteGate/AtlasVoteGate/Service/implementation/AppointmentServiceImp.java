package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;

import com.AtlasVoteGate.AtlasVoteGate.Repository.AppointmentRepo;
import com.AtlasVoteGate.AtlasVoteGate.Repository.UtilisateurRepo;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.AppointmentService;
import com.AtlasVoteGate.AtlasVoteGate.enums.AppointmentStatus;
import com.AtlasVoteGate.AtlasVoteGate.enums.Role;
import com.AtlasVoteGate.AtlasVoteGate.model.Appointment;
import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Observable;
import java.util.Optional;

@Service
@Slf4j
public class AppointmentServiceImp implements AppointmentService {

    private AppointmentRepo appointmentRepo;
    private UtilisateurRepo utilisateurRepo;

    public AppointmentServiceImp ( AppointmentRepo appointmentRepo,UtilisateurRepo utilisateurRepo){
        this.appointmentRepo=appointmentRepo;
        this.utilisateurRepo=utilisateurRepo;
    }

    @Override
    public Appointment save(Appointment appointment) {
        this.appointmentRepo.save(appointment);
        log.info("Appointment saved succesfully");
        return appointment;
    }

    @Override
    public Appointment getAppointment(Long idappointment) {
        Optional<Appointment> appointment=this.appointmentRepo.findById(idappointment);
        if(appointment.isPresent()){
            log.info("Appointment found succesfully");
            return appointment.get();
        }
        log.info("there is no appointment with this id");
        return null;
    }

    @Override
    public void delete(Long idappointment) {
       this.appointmentRepo.deleteById(idappointment);
        log.info("Appointment deleted succesfully");

    }

    @Override
    public List<Appointment> getAllAppointments() {
        return this.appointmentRepo.findAll();
    }

    @Override
    public void update(Long id, Appointment newAppointment) {
        Optional<Appointment> oldAppointmentOptional = this.appointmentRepo.findById(id);
        if (oldAppointmentOptional.isPresent()) {
            Appointment oldAppointment = oldAppointmentOptional.get();
            // Mise à jour des champs
            oldAppointment.setCne(newAppointment.getCne());
            oldAppointment.setStatus(newAppointment.getStatus());
            oldAppointment.setEmail(newAppointment.getEmail());
            oldAppointment.setPassword(newAppointment.getPassword());
            oldAppointment.setAppointmentTime(newAppointment.getAppointmentTime());
            oldAppointment.setNom(newAppointment.getNom());
            oldAppointment.setPrenom(newAppointment.getPrenom());

            // Enregistrer les modifications
            this.appointmentRepo.save(oldAppointment);
            log.info("Appointment updated successfully.");
        } else {
            log.error("No appointment found with this id");
            throw new IllegalArgumentException("No appointment found with id " + id);
        }
    }


    @Override
    public void cancel(Long idappointment) {
        Optional<Appointment> oldAppointmentOptional = this.appointmentRepo.findById(idappointment);
        if (oldAppointmentOptional.isPresent()) {
            Appointment oldAppointment = oldAppointmentOptional.get();
            // Mise à jour des champs
           oldAppointment.setStatus(AppointmentStatus.CANCELED);

            // Enregistrer les modifications
            this.appointmentRepo.save(oldAppointment);
            log.info("Appointment canceled successfully");
        } else {
            log.error("No appointment found with this id");
            throw new IllegalArgumentException("No appointment found with id " + idappointment);
        }


    }

    @Override
    public void verify(Long idappointment) {
        Optional<Appointment> appointmentOptional= this.appointmentRepo.findById(idappointment);

        if(appointmentOptional.isPresent()){
            Appointment appointment=appointmentOptional.get();
            Utilisateur newUtilisateur= new Utilisateur(appointment.getEmail(), Role.ROLE_VOTER,appointment.getPassword(),appointment.getNom(),appointment.getPrenom());
            this.utilisateurRepo.save(newUtilisateur);
            log.info("user created succesfully");
        }

        log.info("there is no appointment with this id");


    }

    @Override
    public List<Appointment> getAppointmentsForToday() {
        LocalDateTime startOfToday = LocalDate.now().atStartOfDay();
        LocalDateTime endOfToday = LocalDate.now().atTime(23, 59, 59);
        return appointmentRepo.findByAppointmentTimeBetweenAndStatus(startOfToday, endOfToday, AppointmentStatus.VERIFIED);
    }

    @Override
    public List<Appointment> getAppointmentsForDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);
        return appointmentRepo.findByAppointmentTimeBetweenAndStatus(startOfDay, endOfDay, AppointmentStatus.VERIFIED);
    }
}
