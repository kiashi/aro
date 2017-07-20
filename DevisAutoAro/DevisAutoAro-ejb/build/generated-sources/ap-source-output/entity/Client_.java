package entity;

import entity.Agence;
import entity.AmSinistre;
import entity.ClBalance;
import entity.ClType;
import entity.RtContrat;
import entity.SouscriptionProduit;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> profession;
    public static volatile ListAttribute<Client, AmSinistre> amSinistreList;
    public static volatile ListAttribute<Client, RtContrat> rtContratList;
    public static volatile SingularAttribute<Client, Date> dateNaissance;
    public static volatile SingularAttribute<Client, String> cin;
    public static volatile SingularAttribute<Client, ClType> clType;
    public static volatile SingularAttribute<Client, String> noclient;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> lieuNaissance;
    public static volatile SingularAttribute<Client, Agence> agence;
    public static volatile SingularAttribute<Client, Date> dateSouscription;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, String> mdp;
    public static volatile ListAttribute<Client, ClBalance> clBalanceList;
    public static volatile ListAttribute<Client, SouscriptionProduit> souscriptionProduitList;
    public static volatile SingularAttribute<Client, String> tel;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> email;

}