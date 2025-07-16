package com.example.ing.controller;

import com.example.ing.dto.AppointmentDto;
import com.example.ing.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/save")
    public ResponseEntity<AppointmentDto> saveAppointment(@RequestBody AppointmentDto appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping("/get-appointments/{email}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByEmail(@PathVariable String email) {
        return appointmentService.getAppointmentsByEmail(email);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAppointments(@RequestBody List<Integer> appointmentsIds) {
        return appointmentService.deleteAppointments(appointmentsIds);
    }
}
