package deloitte.custom.app.mobile;

import java.util.ArrayList; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.List;

public class ReportDetailsData {
    private List s_ReportDetailsData = null;
    public ReportDetailsData() {
        super();
    }
    
    public ReportDetails[] getReportDetailsData() { 
      //This Method gets a list of reports
      ReportDetails[] ReportDetailsData = null; 
      s_ReportDetailsData = new ArrayList(); 
      s_ReportDetailsData.add(new ReportDetails("TestReport1", "UserAccessGroup1","AP", "https://ucf6-fap0510-bi.oracledemos.com:443/mobile/viewer.jsp?_xma=%2F%7Ecasey.brown%2FAppTest.xma")); 
      s_ReportDetailsData.add(new ReportDetails("TestReport2", "UserAccessGroup1", "AP", "https://ucf6-fap0510-bi.oracledemos.com:443/mobile/viewer.jsp?_xma=%2F%7Ecasey.brown%2FAppTest2.xma")); 
      s_ReportDetailsData.add(new ReportDetails("TestReport3", "UserAccessGroup2", "AR", "https://en.wikipedia.org/")); 
      ReportDetailsData = (ReportDetails[]) s_ReportDetailsData.toArray(new ReportDetails[s_ReportDetailsData.size()]); 
      return ReportDetailsData; 
    } 
}
