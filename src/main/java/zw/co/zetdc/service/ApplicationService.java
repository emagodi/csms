package zw.co.zetdc.service;

import zw.co.zetdc.entities.Application;
import zw.co.zetdc.enums.District;
import zw.co.zetdc.enums.Region;
import zw.co.zetdc.enums.Status;
import zw.co.zetdc.payload.request.ApplicationRequest;
import zw.co.zetdc.payload.response.ApplicationResponse;

import java.util.List;

public interface ApplicationService {

    public void submitApplication(ApplicationRequest applicationRequest);
    public List<ApplicationResponse> getAllApplications();


    Application approve(Application application);


    public List<Application> getApplicationsByDistrict(District district);


//    public List<Application> getApplicationsByEmail(String email);


    public List<Application> getApplicationsByRegion(Region region);

    public List<Application> getApplicationByCreatedBy(String createdby);

    public Application getApplicationById(Long id);


    Application updateLineItem(Long applicationId, Long lineItemId, String reason, Status status);



}
