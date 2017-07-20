package entity;

import entity.AmVehicule;
import entity.Client;
import entity.Produit;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(SouscriptionProduit.class)
public class SouscriptionProduit_ { 

    public static volatile SingularAttribute<SouscriptionProduit, Produit> produit;
    public static volatile SingularAttribute<SouscriptionProduit, Double> primenet;
    public static volatile SingularAttribute<SouscriptionProduit, Double> primetotal;
    public static volatile SingularAttribute<SouscriptionProduit, BigInteger> duree;
    public static volatile SingularAttribute<SouscriptionProduit, Client> client;
    public static volatile SingularAttribute<SouscriptionProduit, Integer> id;
    public static volatile ListAttribute<SouscriptionProduit, AmVehicule> amVehiculeList;
    public static volatile SingularAttribute<SouscriptionProduit, Date> daty;
    public static volatile SingularAttribute<SouscriptionProduit, Double> reduction;
    public static volatile SingularAttribute<SouscriptionProduit, String> nopolice;

}