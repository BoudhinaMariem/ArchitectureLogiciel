package tn.esb.bi1.pharmacyApi.domains;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//pour decrire la table association
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class PharmacistPrescription {
    @EmbeddedId //pour dire que id est une clé primaire composite
    private PharmacistPrescriptionId id;
    @Column(name = "purchase_date")
    @NonNull
    private LocalDate date;
    @NonNull
    private BigDecimal amount;

    //definir la relation entre ***
    @ManyToOne
    @MapsId("idPharmacist") //l'instance "phamacist" est liée à une partie de la clé primaire composé
    private Pharmacist pharmacist;

    //definir la relation entre prescription et pharmacistPrescription
    @ManyToOne
    @MapsId("idPrescription")
    private Prescription prescription;
}
