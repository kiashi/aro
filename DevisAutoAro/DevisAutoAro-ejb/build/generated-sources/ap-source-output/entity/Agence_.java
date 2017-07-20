package entity;

import entity.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(Agence.class)
public class Agence_ { 

    public static volatile SingularAttribute<Agence, String> ville;
    public static volatile SingularAttribute<Agence, String> rue;
    public static volatile SingularAttribute<Agence, String> code;
    public static volatile SingularAttribute<Agence, Double> latitude;
    public static volatile SingularAttribute<Agence, String> adresse;
    public static volatile SingularAttribute<Agence, Integer> id;
    public static volatile ListAttribute<Agence, Client> clientList;
    public static volatile SingularAttribute<Agence, String> nom;
    public static volatile SingularAttribute<Agence, Double> longitude;

}