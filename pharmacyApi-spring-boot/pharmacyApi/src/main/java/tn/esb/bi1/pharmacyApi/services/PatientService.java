package tn.esb.bi1.pharmacyApi.services;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.bi1.pharmacyApi.domains.Patient;
import tn.esb.bi1.pharmacyApi.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService {
    @Autowired
    private PatientRepository patientReposi;
    public List<Patient> getAll()
    {
        return patientReposi.findAll();
    }
    public Patient addPatient(Patient patient)
    {
        return patientReposi.save(patient);
    }
    public Optional<Patient> getPatientById(Long id)
    {
        return patientReposi.findById(id);
    }
}
