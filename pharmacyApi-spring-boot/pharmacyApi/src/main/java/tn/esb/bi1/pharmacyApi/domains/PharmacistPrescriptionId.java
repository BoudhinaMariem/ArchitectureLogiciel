package tn.esb.bi1.pharmacyApi.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable //l'existence de cette classe est depend de la classe "PharmacistPrescription"
//pout definir la clé primaire composite
//une classe Emneddable doit necessairement implementer l'interface serializable , doit aussi redefinir Equals and HashCode , doit avoir un constructeur non parametrie et parametrie
public class PharmacistPrescriptionId implements Serializable {   //Serializable pas implementer des methode
    @Column(name = "pharmacist_id")
    private Long idPharmacist;
    @Column(name = "prescription_id")
    private Long idPrescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacistPrescriptionId that = (PharmacistPrescriptionId) o;
        return idPharmacist.equals(that.idPharmacist) && idPrescription.equals(that.idPrescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPharmacist, idPrescription);
    }
}
