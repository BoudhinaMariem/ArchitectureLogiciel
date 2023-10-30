package tn.esb.bi1.pharmacyApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esb.bi1.pharmacyApi.domains.PharmacistPrescription;
import tn.esb.bi1.pharmacyApi.domains.PharmacistPrescriptionId;

public interface PharmacistRepository extends JpaRepository<PharmacistPrescription, PharmacistPrescriptionId> {
}
