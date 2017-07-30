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
        //LatLng coord2 = new LatLng(36.883707, 30.689216);
        //LatLng coord3 = new LatLng(36.879703, 30.706707);
        //LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Aro Antsahavola"));
        //simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
        //simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
        //simpleModel.addOverlay(new Marker(coord4, "Kaleici"));
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