package tn.esb.bi2.ecommerceApi.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
@Data  //genere getters, setters, RequiredArgsConstructor, ToString et equalsAndHashCode
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
//@Table(name = "provider_tab") //permet de personnaliser la table au moment de generation du code SQL par l'ORM
//on peut preciser son nom (par defaut c'est le nom de la classe, les contraintes unique
@Table(name="provider_tab",uniqueConstraints = { @UniqueConstraint(name = "UniqueNameAndEmailConstraint", columnNames = { "email", "provider_name" }) })
//permet d'ajouter une containte nommée 'UniqueNameAndEmailConstraint' précisant que les colonnes nom et email sont uniques
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //la valeur de l'id sera auto-incrimentée de 1 à chaque ajout en commençant de 1 aussi
    private Long id;
    @NonNull
    @Column(name = "provider_name", unique = true, nullable = false,length = 100)
    //personaliser la colonne en pricisant par example son nom, unique ou nom,...
    private String name;
    @NonNull
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String email;
    @NonNull
    private String telephone;
    private String siteUrl;
}
