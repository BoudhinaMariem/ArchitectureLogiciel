package tn.esb.bi2.ecommerceApi.Domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//Cette classe sert à definir la clé primaire composite de l'entité "Command"
@Embeddable //cette classe ne sera pas transformée en table par l'ORM. En plus l'existence
//de cette classe est liée à celle de la classe "Command"
//Une classe annotée Embeddable doit être Serializable, doit definir deux constructeurs (non paramétré et paramétré)
//et doit redefinir Equals et hashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommandId implements Serializable {
    @Column(name="product_id")
    private Long idProduct;
    @Column(name="customer_id")
    private Long idCustomer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandId commandId = (CommandId) o;
        return idProduct.equals(commandId.idProduct) && idCustomer.equals(commandId.idCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idCustomer);
    }
}
