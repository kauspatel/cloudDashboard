package deloitte.custom.app.application.model.service;

import deloitte.custom.app.application.model.Features;

import java.util.ArrayList;
import java.util.List;

public class FeaturesService {
    private List s_features = null;
    public FeaturesService() {
        super();
    }
    public Features[] getFeatures() {
           Features[] features = null; 
           s_features = new ArrayList();
           s_features.add(new Features("Dashboard","deloitte.custom.app.Dashboard", "Dashboard"));
           s_features.add(new Features("Settings","deloitte.custom.app.Settings", "Settings"));
           s_features.add(new Features("Log Out","deloitte.custom.app.Settings", "Log_out"));
           features = (Features[]) s_features.toArray(new Features[s_features.size()]); 
           return features; 
         } 
}
