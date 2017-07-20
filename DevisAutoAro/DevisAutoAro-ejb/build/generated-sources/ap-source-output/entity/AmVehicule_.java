package entity;

import entity.AmSinistre;
import entity.SouscriptionProduit;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(AmVehicule.class)
public class AmVehicule_ { 

    public static volatile SingularAttribute<AmVehicule, String> noserie;
    public static volatile SingularAttribute<AmVehicule, String> sourceEnergie;
    public static volatile ListAttribute<AmVehicule, AmSinistre> amSinistreList;
    public static volatile SingularAttribute<AmVehicule, String> carrosserie;
    public static volatile SingularAttribute<AmVehicule, BigInteger> remorque;
    public static volatile SingularAttribute<AmVehicule, Date> finVisiteTech;
    public static volatile SingularAttribute<AmVehicule, String> noimm;
    public static volatile SingularAttribute<AmVehicule, BigInteger> puissanceFisc;
    public static volatile SingularAttribute<AmVehicule, String> type;
    public static volatile SingularAttribute<AmVehicule, Double> poidsVide;
    public static volatile SingularAttribute<AmVehicule, String> marque;
    public static volatile SingularAttribute<AmVehicule, Date> dateMiseEnCirc;
    public static volatile SingularAttribute<AmVehicule, BigInteger> nbPlace;
    public static volatile SingularAttribute<AmVehicule, Double> poidsCharge;
    public static volatile SingularAttribute<AmVehicule, SouscriptionProduit> souscriptionProduit;
    public static volatile SingularAttribute<AmVehicule, Integer> id;
    public static volatile SingularAttribute<AmVehicule, Date> debutVisiteTech;

}