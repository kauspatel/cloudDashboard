package deloitte.custom.app.application.model;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Features {
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Features() {
        super();
    }
    private String feature_name;
    private String feature_id;
    private String icon_name;

     public Features(String feature_name, String feature_id, String icon_name) {
         super();
         this.feature_name = feature_name;
         this.feature_id = feature_id;
         this.icon_name = icon_name;
     }

    public void setFeature_name(String feature_name) {
        String oldFeature_name = this.feature_name;
        this.feature_name = feature_name;
        _propertyChangeSupport.firePropertyChange("feature_name", oldFeature_name, feature_name);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_id(String feature_id) {
        String oldFeature_id = this.feature_id;
        this.feature_id = feature_id;
        _propertyChangeSupport.firePropertyChange("feature_id", oldFeature_id, feature_id);
    }

    public String getFeature_id() {
        return feature_id;
    }

    public void setIcon_name(String icon_name) {
        String oldIcon_name = this.icon_name;
        this.icon_name = icon_name;
        _propertyChangeSupport.firePropertyChange("icon_name", oldIcon_name, icon_name);
    }

    public String getIcon_name() {
        return icon_name;
    }
}
