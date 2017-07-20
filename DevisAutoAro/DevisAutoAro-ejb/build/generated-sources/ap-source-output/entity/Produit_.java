package entity;

import entity.SouscriptionProduit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, String> nompage;
    public static volatile SingularAttribute<Produit, String> description;
    public static volatile ListAttribute<Produit, SouscriptionProduit> souscriptionProduitList;
    public static volatile SingularAttribute<Produit, Integer> id;
    public static volatile SingularAttribute<Produit, String> intitule;

}