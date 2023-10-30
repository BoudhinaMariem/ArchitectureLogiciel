package tn.esb.bi1.pharmacyApi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esb.bi1.pharmacyApi.domains.Patient;
import tn.esb.bi1.pharmacyApi.services.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
//url de patientController => http:/localhost:9592/patients
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientServ;

    @GetMapping("/all")
    //url de cette methode => http:/localhost:9592/patients/all
    public List<Patient> getAllPatients()
    {
        return patientServ.getAll();
    }
    @PostMapping("/add")
    //url de cette methode => http:/localhost:9592/patients/add
    public Patient addNewPatient(@Valid @RequestBody Patient patient){
        return patientServ.addPatient(patient);
    }
    @GetMapping("/patient/{numss}")
    public Optional<patient> getPatient(@PathVariable Long numss)
    {
        return patientServ.getPatientById(numss)
    }
}
