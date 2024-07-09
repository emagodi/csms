package zw.co.zetdc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    Page<Application> getAllApplicationsByDistrict(District district, int page , int size);


//    public List<Application> getApplicationsByEmail(String email);


    public List<Application> getApplicationsByRegion(Region region);

    public List<Application> getApplicationByCreatedBy(String createdby);

    public Application getApplicationById(Long id);


    Application updateLineItem(Long applicationId, Long lineItemId, String reason, Status status);


    List<Application> getApplicationBySearch(String createdby, Long applicationId);

    List<Application> getDistrictApplicationBySearch(District district, Long applicationId);

    //List<Application> getPendingApplicationsByDistrict(District district);
    Page<Application> getPendingApplicationsByDistrict(District district, int page , int size);

    List<Application> getPendingDistrictApplicationBySearch(District district, Long applicationId);

    List<Application> getApplicationsByDistrictForInspection(District district);

    List<Application> getApplicationForInspectionBySearch(District district, Long applicationId);

    List<Application> getPendingApplicationsByDistrictForInspection(District district);

    List<Application> getPendingApplicationForInspectionBySearch(District district, Long applicationId);

    List<Application> getApplicationForStoresBySearch(District district, Long applicationId);

    List<Application> getAllApplicationsByDistrictForStores(District district);

    List<Application> getNumApplicationsByDistrict(District district);
}
