package entity;

import entity.AmVehicule;
import entity.Client;
import entity.PhotoSinistre;
import entity.SinSuivi;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(AmSinistre.class)
public class AmSinistre_ { 

    public static volatile ListAttribute<AmSinistre, PhotoSinistre> photoSinistreList;
    public static volatile SingularAttribute<AmSinistre, String> libelle;
    public static volatile SingularAttribute<AmSinistre, AmVehicule> amVehicule;
    public static volatile ListAttribute<AmSinistre, SinSuivi> sinSuiviList;
    public static volatile SingularAttribute<AmSinistre, Client> client;
    public static volatile SingularAttribute<AmSinistre, String> details;
    public static volatile SingularAttribute<AmSinistre, Integer> id;
    public static volatile SingularAttribute<AmSinistre, Date> daty;
    public static volatile SingularAttribute<AmSinistre, String> lieu;

}