package com.example.patientmanagement.service;

import com.example.patientmanagement.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private static final List<Patient> patients = new ArrayList<>();

    static {
        patients.add(new Patient(1L, "John Doe", 30, "Flu"));
        patients.add(new Patient(2L, "Jane Smith", 25, "Covid-19"));
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatientById(Long id) {
        return patients.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

