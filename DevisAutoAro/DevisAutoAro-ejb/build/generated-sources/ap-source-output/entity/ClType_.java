package entity;

import entity.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(ClType.class)
public class ClType_ { 

    public static volatile SingularAttribute<ClType, String> libelle;
    public static volatile SingularAttribute<ClType, Integer> id;
    public static volatile ListAttribute<ClType, Client> clientList;

}