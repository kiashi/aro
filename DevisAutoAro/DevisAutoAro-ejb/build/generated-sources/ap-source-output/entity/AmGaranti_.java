package entity;

import entity.AmTauxgaranti;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-13T10:45:30")
@StaticMetamodel(AmGaranti.class)
public class AmGaranti_ { 

    public static volatile SingularAttribute<AmGaranti, String> code;
    public static volatile SingularAttribute<AmGaranti, Integer> idamgaranti;
    public static volatile SingularAttribute<AmGaranti, String> libelle;
    public static volatile ListAttribute<AmGaranti, AmTauxgaranti> amTauxgarantiList;

}