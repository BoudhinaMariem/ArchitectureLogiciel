package tn.esb.bi2.ecommerceApi.Domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter //genère au moment du runtime tous les getters pour tous les attributs
@Setter
@NoArgsConstructor //genère un constructeur non parametré
@AllArgsConstructor //genère un constructeur avec tous les paramètres
@RequiredArgsConstructor //genère un constructeur avec les attributs obligatoires comme paramètres
//@ToString //permet de retourner une chaine de caractères contenant les valeurs de tous les attributs
//@ToString(exclude ={"image","fabricationDate"})//retourne les valeurs de toutes les colonnes sauf "image" et "fabricationDate"
@ToString(exclude="image")
//@EqualsAndHashCode //genère une redefinition de Equals et HashCode en se basant sur tous les attributs
//@EqualsAndHashCode(exclude={"image","price","description"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//la comparaison sera fait via uniquement les attributs annotés avec Include
@Entity //La classe Product sera transformée par l'ORM : Object Relational Mapping en une table relationnelle
public class Product {
    @Id //l'attribut "id" est la clé primaire de la table
    @GeneratedValue //l'attribut est automatiquement generé
    private Long id;
    @EqualsAndHashCode.Include
    @NonNull //label est obligatoire
    private String label;
    @NonNull
    @Column(precision = 7, scale = 3) //7 chiffres en total y compris 3 chiffres après virgules
    private double price;
    @NonNull
    @EqualsAndHashCode.Include
    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate expirationDate;
    @NonNull
    @EqualsAndHashCode.Include
    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate fabricationDate;
    @Column(columnDefinition = "int default 0")//specifier une valeur par defaut
    private int stock;
    private String description;
    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Command> commands = new HashSet<>();

}
