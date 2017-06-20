package deloitte.custom.app.application;




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import java.util.Set;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeSupport;

import oracle.adfmf.util.Utility;
import java.util.Map.Entry;


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

    public String naviagateToReportUrl() {
        // Add event code here...
        String featureID = AdfmfJavaUtilities.getFeatureId();
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(featureID, "navigateToReportUrl", new Object[] {AdfmfJavaUtilities.getELValue("#{pageFlowScope.currReportUrl}")});
        return null;
    }
    
    public void processSpeech(String speechText){
        System.out.println("::::"+speechText+":::::");
        String featureID = AdfmfJavaUtilities.getFeatureId();
        if(speechText.length()>4){
            String s=getFilteredReportUrl(speechText);
            
            if(s.length()>10){                
                AdfmfContainerUtilities.invokeContainerJavaScriptFunction(featureID, "navigateToReportUrl", new Object[] {s});
            }else{
                AdfmfContainerUtilities.invokeContainerJavaScriptFunction(featureID, "showAlert", new Object[] {speechText});
            }
        }else{
            AdfmfContainerUtilities.invokeContainerJavaScriptFunction(featureID, "showAlert", new Object[] {speechText});
        }
        
        
    }

    public String startVoiceRecognition() {
        // Add event code here...
        String featureID = AdfmfJavaUtilities.getFeatureId();
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(featureID, "StartSpeechToText", new Object[] {});
        return null;
    }
    
    public String getFilteredReportUrl(String searchKeyword) {
        Connection conn = null;
        String returnValue = "";
        try {
            String[] searchKeyworkArray=searchKeyword.split(" "); 
            Collection listTwo = new ArrayList(Arrays.asList(searchKeyworkArray));
            conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            StringBuffer query = new StringBuffer();
            query.append("SELECT REPORT_URL FROM REPORT_DETAILS");
            Map<String, Integer> map = new HashMap<String, Integer>(); 
            ResultSet result = stmt.executeQuery(query.toString());
            while (result.next()) {
                System.out.println("inside first while");
                String reportUrl = (String) result.getObject("REPORT_URL");
                String[] reportUrlArray=reportUrl.split(",");
                Collection listOne = new ArrayList(Arrays.asList(reportUrlArray));
                listOne.retainAll( listTwo );
                map.put(reportUrl, listOne.size());
            }
            Set<Entry<String, Integer>> set = map.entrySet();
                    List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
                    Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
                    {
                        public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
                        {
                            return (o2.getValue()).compareTo( o1.getValue() );
                        }
                    } );
            for(Map.Entry<String, Integer> entry:list){
                        System.out.println(entry.getKey()+" ==== "+entry.getValue());
                        returnValue=entry.getKey();
                break;
             }
            
        } catch (Exception ex) {
            Utility.ApplicationLogger.severe(ex.getMessage());
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return returnValue;
    }
    
   
}
