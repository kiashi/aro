package entity;

import entity.AmTauxgaranti;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-18T11:27:05")
@StaticMetamodel(AmGaranti.class)
public class AmGaranti_ { 

    public static volatile SingularAttribute<AmGaranti, String> code;
    public static volatile SingularAttribute<AmGaranti, String> libelle;
    public static volatile ListAttribute<AmGaranti, AmTauxgaranti> amTauxgarantiList;
    public static volatile SingularAttribute<AmGaranti, Integer> id;

}