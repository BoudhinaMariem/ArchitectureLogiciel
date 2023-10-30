package tn.esb.bi1.pharmacyApi.domains;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data  //remplace @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "Lab_tab",uniqueConstraints = {@UniqueConstraint(name = "UniqueNameAndEmail",columnNames = {"name","email"})})
        //permet de personaliser les informations sur une table
public class Laboratory {
    @Id
    //@GeneratedValue par defaut auto valeur automatique sans ordre
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull //name est obligatoire
    @Column(name = "lab_name", length = 50 ) //permet de personaliser les colonnes au moment de génération du code SQL par l'ORM
    //comme le nom de la colonnes (par defaut c'est le nom du l'attribut),taille,nombre de chiffre apres la virgule,unique ,unique = true
    private String name;
    @NonNull //email est obligatoire
    //@Column(unique = true)   //pour dire que email est unique
    private String email;
    @NonNull //phoneNumber est obligatoire
    private String phoneNumber;  //+216 ** *** ***
    private String siteUrl;
    private String salesManagerName;

    @OneToOne(mappedBy = "lab",cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id") //définition du clé étrangère "address_id"
    //referencedColumnName est optionnel
    private Address laboratoryAdresse;
    @OneToMany(mappedBy="drugLaboratory",cascade = CascadeType.ALL)
    private Set<Drug> drugs=new HashSet<>();
}
