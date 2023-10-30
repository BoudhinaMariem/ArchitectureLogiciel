package tn.esb.bi1.pharmacyApi.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Patient {
    @Id
    private Long numSS;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd")
    @NonNull
    private LocalDate birthDate;
    @NonNull
    @JsonFormat(pattern="YYYY-MM-dd")
    private String email;
    @NonNull
    private Integer phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return numSS.equals(patient.numSS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSS);
    }
}
