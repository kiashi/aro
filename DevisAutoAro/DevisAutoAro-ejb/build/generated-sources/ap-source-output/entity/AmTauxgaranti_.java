package entity;

import entity.AmCategorietarifaire;
import entity.AmGaranti;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T14:51:17")
@StaticMetamodel(AmTauxgaranti.class)
public class AmTauxgaranti_ { 

    public static volatile SingularAttribute<AmTauxgaranti, AmCategorietarifaire> idcodetarifaire;
    public static volatile SingularAttribute<AmTauxgaranti, AmGaranti> idamgaranti;
    public static volatile SingularAttribute<AmTauxgaranti, Double> taux;
    public static volatile SingularAttribute<AmTauxgaranti, String> libelle;
    public static volatile SingularAttribute<AmTauxgaranti, Integer> idgaranti;

}