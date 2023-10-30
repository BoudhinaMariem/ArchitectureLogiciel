package tn.esb.bi1.pharmacyApi.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
////////////////////////////na9es
@Entity
public class Pharmacist {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) au lieux de id on met cin
    @Column(name = "pharmacist_cin", length = 8)
    private String cin; //on peut met un 0 f cin et l'entier pas de 0 au debut
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    @JsonFormat(pattern="hh:mm")
    @NonNull
    private LocalTime startTime;

    //relation avec pharmacist et prescription
    private Set<PharmacistPrescription> pharmacistPrescriptionSet=new HashSet<>();
    @OneToMany(mappedBy = "pharmacist",cascade)


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacist that = (Pharmacist) o;
        return cin.equals(that.cin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cin);
    }
}
