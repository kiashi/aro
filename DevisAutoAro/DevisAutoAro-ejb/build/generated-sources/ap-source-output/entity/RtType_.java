package entity;

import entity.RtContrat;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(RtType.class)
public class RtType_ { 

    public static volatile ListAttribute<RtType, RtContrat> rtContratList;
    public static volatile SingularAttribute<RtType, String> code;
    public static volatile SingularAttribute<RtType, Double> taux;
    public static volatile SingularAttribute<RtType, String> libelle;
    public static volatile SingularAttribute<RtType, String> description;
    public static volatile SingularAttribute<RtType, Integer> id;

}