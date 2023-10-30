package tn.esb.bi1.pharmacyApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bi1.pharmacyApi.domains.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    //l'interface JpaRepository est predefinie dans la dependance Maven spring-data jpa
    // avec dans ce repository S<-->Patient et T<-->Long
    //cette interface presente des methodes comme
    //List<Patient> findALL() : permet de retourner tous les patients
    //Optional<Patient> findById(Long id) : retourne le patient de la base de donnée ayant celui fourni en parametre ou bien elle ne retourne rien
    //Optional peut contenir seulement un seul element ou bien zero element
    //Optional<Patient> res=patientRepos.findById(5);
    //if(res.isPresent()) ou if(res.isEmpty())
    //recuperer le patient dans Optional s'il existe : Patient p=res.get();

    //Patient save(Patient p) :joue double role:
    //->la création (Ajout)
    //->la mise à jour

    //suppression : void deleteById(Long id)

}
