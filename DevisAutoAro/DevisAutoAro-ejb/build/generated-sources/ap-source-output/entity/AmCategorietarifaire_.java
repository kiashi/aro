package entity;

import entity.AmPrime;
import entity.AmTauxgaranti;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T14:51:17")
@StaticMetamodel(AmCategorietarifaire.class)
public class AmCategorietarifaire_ { 

    public static volatile SingularAttribute<AmCategorietarifaire, Integer> idcodetarifaire;
    public static volatile SingularAttribute<AmCategorietarifaire, String> nomenclature;
    public static volatile SingularAttribute<AmCategorietarifaire, BigInteger> nbrouesmax;
    public static volatile SingularAttribute<AmCategorietarifaire, BigInteger> nbrouesmin;
    public static volatile ListAttribute<AmCategorietarifaire, AmPrime> amPrimeList;
    public static volatile SingularAttribute<AmCategorietarifaire, String> libelle;
    public static volatile ListAttribute<AmCategorietarifaire, AmTauxgaranti> amTauxgarantiList;

}