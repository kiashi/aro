package entity;

import entity.AmSinistre;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(SinSuivi.class)
public class SinSuivi_ { 

    public static volatile SingularAttribute<SinSuivi, String> libelle;
    public static volatile SingularAttribute<SinSuivi, AmSinistre> amSinistre;
    public static volatile SingularAttribute<SinSuivi, BigInteger> fait;
    public static volatile SingularAttribute<SinSuivi, String> description;
    public static volatile SingularAttribute<SinSuivi, Integer> id;
    public static volatile SingularAttribute<SinSuivi, String> noEtape;

}