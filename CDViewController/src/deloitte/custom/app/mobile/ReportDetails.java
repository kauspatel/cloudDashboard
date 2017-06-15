package deloitte.custom.app.mobile;

import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class ReportDetails {
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public ReportDetails() {
        super();
    }
    
    private String reportName ;
    private String userAccessGroup;
    private String module;
    private String reportURL;
    
    public ReportDetails(String reportName, String userAccessGroup, String module, String reportURL) {
        super();
        this.reportName = reportName;
        this.userAccessGroup = userAccessGroup;
        this.module = module;
        this.reportURL = reportURL;
    }

    public void setReportName(String reportName) {
        String oldReportName = this.reportName;
        this.reportName = reportName;
        _propertyChangeSupport.firePropertyChange("reportName", oldReportName, reportName);
    }

    public String getReportName() {
        return reportName;
    }

    public void setUserAccessGroup(String userAccessGroup) {
        String oldUserAccessGroup = this.userAccessGroup;
        this.userAccessGroup = userAccessGroup;
        _propertyChangeSupport.firePropertyChange("userAccessGroup", oldUserAccessGroup, userAccessGroup);
    }

    public String getUserAccessGroup() {
        return userAccessGroup;
    }

    public void setModule(String module) {
        String oldModule = this.module;
        this.module = module;
        _propertyChangeSupport.firePropertyChange("module", oldModule, module);
    }

    public String getModule() {
        return module;
    }

    public void setReportURL(String reportURL) {
        String oldReportURL = this.reportURL;
        this.reportURL = reportURL;
        _propertyChangeSupport.firePropertyChange("reportURL", oldReportURL, reportURL);
    }

    public String getReportURL() {
        return reportURL;
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
