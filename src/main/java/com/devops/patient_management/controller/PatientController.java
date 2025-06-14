package com.devops.patient_management.controller;

import com.devops.patient_management.model.Patient;
import com.devops.patient_management.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.devops.patient_management.metrics.MetricsService;


import java.util.List;

@RestController
@RequestMapping("/api/patients")
@Slf4j
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private MetricsService metricsService;

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        log.info("info logs getAllPatients");
        log.debug("debug logs getAllPatients");
        log.error("error logs getAllPatients");
        log.warn("warn logs getAllPatients");
        log.trace("trace logs getAllPatients");
        return patientService.getAllPatients();
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }



}

