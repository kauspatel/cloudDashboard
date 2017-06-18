package deloitte.custom.app.application;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ChartDrillEvent;
import oracle.adfmf.amx.event.SelectionEvent;
import oracle.adfmf.bindings.dbf.AmxIteratorBinding;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.exception.AdfInvocationException;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONObject;
import oracle.adfmf.util.GenericType;

import oracle.maf.api.dc.ws.rest.RestServiceAdapter;
import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;


public class CloudManagedBean {
    boolean springBoardStatus = false;
    String currentFeature;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setSpringBoardStatus(boolean springBoardStatus) {
        boolean oldSpringBoardStatus = this.springBoardStatus;
        this.springBoardStatus = springBoardStatus;
        propertyChangeSupport.firePropertyChange("springBoardStatus", oldSpringBoardStatus, springBoardStatus);
    }

    public boolean isSpringBoardStatus() {
        return springBoardStatus;
    }

    public CloudManagedBean() {
        super();
    }

    public void openSpringboard(ActionEvent actionEvent) {
        currentFeature = AdfmfJavaUtilities.getFeatureId();
        AdfmfJavaUtilities.setELValue("#{applicationScope.CloudManagedBean.springBoardStatus}", true);
        AdfmfContainerUtilities.gotoSpringboard();
    }

    public void closeSpringBoard(ActionEvent actionEvent) {
        AdfmfJavaUtilities.setELValue("#{applicationScope.CloudManagedBean.springBoardStatus}", false);
        AdfmfContainerUtilities.gotoFeature(currentFeature);
    }

    public void setCurrentFeature(String currentFeature) {
        String oldCurrentFeature = this.currentFeature;
        this.currentFeature = currentFeature;
        propertyChangeSupport.firePropertyChange("currentFeature", oldCurrentFeature, currentFeature);
    }

    public String getCurrentFeature() {
        return currentFeature;
    }
}
