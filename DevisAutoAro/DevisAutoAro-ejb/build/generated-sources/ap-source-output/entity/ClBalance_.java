package entity;

import entity.Client;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(ClBalance.class)
public class ClBalance_ { 

    public static volatile SingularAttribute<ClBalance, Double> valeur;
    public static volatile SingularAttribute<ClBalance, BigInteger> retire;
    public static volatile SingularAttribute<ClBalance, String> libelle;
    public static volatile SingularAttribute<ClBalance, Client> client;
    public static volatile SingularAttribute<ClBalance, Integer> id;
    public static volatile SingularAttribute<ClBalance, String> motif;
    public static volatile SingularAttribute<ClBalance, Date> daty;

}