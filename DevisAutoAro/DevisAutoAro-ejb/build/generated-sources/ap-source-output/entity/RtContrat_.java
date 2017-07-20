package entity;

import entity.Client;
import entity.RtDepot;
import entity.RtOptionRetrait;
import entity.RtPeriodiciteCotisation;
import entity.RtType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-20T16:24:29")
@StaticMetamodel(RtContrat.class)
public class RtContrat_ { 

    public static volatile SingularAttribute<RtContrat, Client> client;
    public static volatile SingularAttribute<RtContrat, Integer> id;
    public static volatile SingularAttribute<RtContrat, Date> daty;
    public static volatile SingularAttribute<RtContrat, RtPeriodiciteCotisation> rtPeriodiciteCotisation;
    public static volatile SingularAttribute<RtContrat, String> nopolice;
    public static volatile ListAttribute<RtContrat, RtDepot> rtDepotList;
    public static volatile SingularAttribute<RtContrat, String> beneficiaireCasDeces;
    public static volatile SingularAttribute<RtContrat, RtOptionRetrait> rtOptionRetrait;
    public static volatile SingularAttribute<RtContrat, RtType> rtType;

}