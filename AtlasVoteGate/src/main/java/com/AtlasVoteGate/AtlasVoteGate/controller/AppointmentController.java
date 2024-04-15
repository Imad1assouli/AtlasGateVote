package com.AtlasVoteGate.AtlasVoteGate.controller;

import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.AppointmentService;
import com.AtlasVoteGate.AtlasVoteGate.dto.AppointmentDTO;
import com.AtlasVoteGate.AtlasVoteGate.model.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/appointments")
@CrossOrigin("*")
public class AppointmentController {
    private AppointmentService appointmentService;

    @GetMapping("/all")
    public List<Appointment> getAllAppointments() { return appointmentService.getAllAppointments(); }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointment(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/utilisateur/{id}")
    public List<AppointmentDTO> getAppointmentsByUtilisateurID(@PathVariable Long id){
        return appointmentService.getAppointmentsByUtilisateurID(id);
    }

    @GetMapping("Utilisateur/{cni}")
    public List<AppointmentDTO> getAppointmentsByUtilisateurCNI(@PathVariable String cni){
        return appointmentService.getAppointmentsByUtilisateurCNI(cni);
    }

    @GetMapping("Utilisateur/{nom}")
    public List<AppointmentDTO> getAppointmentsByUtilisateurNom(@PathVariable String nom){
        return appointmentService.getAppointmentsByUtilisateurNom(nom);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointmentById(id);
    }

    @PutMapping("/edit/{id}")
    public AppointmentDTO editAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointment){
        appointment.setId(id);
        return appointmentService.updateAppointment(id, appointment);
    }

    @PostMapping("/new-appointment")
    public AppointmentDTO newAppointment(@RequestBody AppointmentDTO appointment){
        return appointmentService.createAppointment(appointment);
    }
}
