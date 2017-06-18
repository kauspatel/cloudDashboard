package deloitte.custom.app.application.model;

import oracle.maf.api.cdm.persistence.model.Entity;


public class ReportDetails extends Entity {

    private String reportId;
    private String reportName;
    private String reportUrl;
    private String reportGraphType;
    private String userRole;
    private String reportKeywords;
    private String reportModule;


    public String getReportId() {
        return this.reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return this.reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getReportGraphType() {
        return this.reportGraphType;
    }

    public void setReportGraphType(String reportGraphType) {
        this.reportGraphType = reportGraphType;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getReportKeywords() {
        return this.reportKeywords;
    }

    public void setReportKeywords(String reportKeywords) {
        this.reportKeywords = reportKeywords;
    }

    public String getReportModule() {
        return this.reportModule;
    }

    public void setReportModule(String reportModule) {
        this.reportModule = reportModule;
    }


}
