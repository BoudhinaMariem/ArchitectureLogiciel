package tn.esb.bi1.pharmacyApi.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    @NonNull
    private LocalDate visitDate;
    @NonNull
    private Integer treatmentDuration;
    private Double amount;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NonNull
    private LocalDate purchaseDate;
    //redegine(generate) equals and hashCode

    //implementation de la relation n-n entre "drug" et "prescription"
    @ManyToMany(mappedBy="prescriptions")
    @ToString.Exclude
    private Set<Drug> drug=new HashSet<>();

    //relation avec PharmacistPrescription
    @OneToMany(mappedBy = "prescription",cascade=CascadeType.ALL)
    @ToString.Exclude
    private Set<PharmacistPrescription> pharmacistPrescriptionSet=new HashSet<>();

}