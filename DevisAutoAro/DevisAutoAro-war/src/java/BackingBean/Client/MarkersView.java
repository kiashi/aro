package org.primefaces.showcase.view.data.gmap;
 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
  
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
@ViewScoped
public class MarkersView implements Serializable {
     
    private MapModel simpleModel;
  
    private Marker marker;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(-18.908639, 47.522231);
        LatLng coord2 = new LatLng(-12.323135, 49.294283);
        LatLng coord3 = new LatLng(-13.315019, 48.259261);
        LatLng coord4 = new LatLng(-14.906124, 50.278549);
        LatLng coord5 = new LatLng(-13.663534, 48.453742);
        LatLng coord6 = new LatLng(-14.906124, 50.278549);
        LatLng coord7 = new LatLng(-14.271334, 50.167812);
        LatLng coord8 = new LatLng(-15.692149, 46.333686);
        LatLng coord9 = new LatLng(-18.144281, 49.395784);
        LatLng coord10 = new LatLng(-17.833636, 48.408801);
        LatLng coord11 = new LatLng(-19.873008, 47.029116);
        LatLng coord12 = new LatLng(-21.454615, 47.087505);
        LatLng coord13 = new LatLng(-20.290419, 44.299996);
        LatLng coord14 = new LatLng(-22.143229, 48.005982);
        LatLng coord15 = new LatLng(-23.351619, 43.685494);
        LatLng coord16 = new LatLng(-25.005973, 46.900635);
        
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Antananarivo"));
        simpleModel.addOverlay(new Marker(coord2, "Antsiranana"));
        simpleModel.addOverlay(new Marker(coord3, "Nosy Be"));
        simpleModel.addOverlay(new Marker(coord4, "Antalaha"));
        simpleModel.addOverlay(new Marker(coord5, "Ambanja"));
        simpleModel.addOverlay(new Marker(coord6, "Sambava"));
        simpleModel.addOverlay(new Marker(coord7, "Mahajanga"));
        simpleModel.addOverlay(new Marker(coord8, "Toamasina"));
        simpleModel.addOverlay(new Marker(coord9, "Ambatondrazaka"));
        simpleModel.addOverlay(new Marker(coord10, "Antsirabe"));
        simpleModel.addOverlay(new Marker(coord11, "Fianarantsoa"));
        simpleModel.addOverlay(new Marker(coord12, "Morondava"));
        simpleModel.addOverlay(new Marker(coord13, "Manakara"));
        simpleModel.addOverlay(new Marker(coord14, "Toliara"));
        simpleModel.addOverlay(new Marker(coord15, "Tolagnaro"));
        simpleModel.addOverlay(new Marker(coord16, "Tolagnaro"));
        
    }
      
    public MapModel getSimpleModel() {
        return simpleModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nom", marker.getTitle()));
    }
      
    public Marker getMarker() {
        return marker;
    }
}