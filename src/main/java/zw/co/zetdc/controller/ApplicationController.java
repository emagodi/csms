package zw.co.zetdc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zw.co.zetdc.email.StatusChangeService;
import zw.co.zetdc.entities.Application;
import zw.co.zetdc.enums.District;
import zw.co.zetdc.enums.Region;
import zw.co.zetdc.enums.Status;
import zw.co.zetdc.payload.request.ApplicationRequest;
import zw.co.zetdc.payload.request.UpdateLineItemRequest;
import zw.co.zetdc.payload.response.ApplicationResponse;
import zw.co.zetdc.service.ApplicationService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ApplicationController {

    private final ApplicationService applicationService;


    private final StatusChangeService statusChangeService;



    @PostMapping("/apply")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE') and hasAnyRole('USER')")
    public String submitApplication(@RequestBody ApplicationRequest applicationRequest) {
        log.info("Submitting Application");
        applicationService.submitApplication(applicationRequest);
        return "Application submitted successfully";
    }

    @GetMapping("/applications")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('MANAGINGDIRECTOR')")
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationResponse> getAllApplications(){
        return applicationService.getAllApplications();
    }


    @PutMapping("/approve/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasAnyRole('USER','DISTRICTMANAGER' , 'GENERALMANAGER', 'MANAGINGDIRECTOR' , 'STORESCLERK' , 'PROJECTENGINEER')")
    public ResponseEntity<Application> approve(@PathVariable("id") Long id, @RequestBody Application application){
        application.setId(id);
        Application approve = applicationService.approve(application);

        return new ResponseEntity<>(approve, HttpStatus.OK);
    }


    @GetMapping("/district/{district}/all")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('DISTRICTMANAGER' , 'STORESCLERK' , 'PROJECTENGINEER')")
    public List<Application> getApplicationsByDistrict(@PathVariable("district") District district,@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size) {
        return applicationService.getNumApplicationsByDistrict(district);
    }

    @GetMapping("/district/{district}")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('DISTRICTMANAGER')")
    @ResponseStatus(HttpStatus.OK)
    public Page<Application> getAllApplicationsForDistrict(
            @PathVariable("district") District district,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return applicationService.getAllApplicationsByDistrict(district, page, size);
    }


    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/inspect/pending")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole( 'PROJECTENGINEER')")
    public List<Application> getPendingApplicationsByDistrictForInspection(@PathVariable("district") District district) {
        return applicationService.getPendingApplicationsByDistrictForInspection(district);
    }
    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/inspect/search/{applicationId}/pending")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('PROJECTENGINEER')")
    public List<Application> getPendingApplicationsForInspectionBySearch(@PathVariable("district") District district, @PathVariable("applicationId") Long applicationId) {
        return applicationService.getPendingApplicationForInspectionBySearch(district, applicationId);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/stores")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole( 'STORESCLERK' )")
    public List<Application> getStoresApplicationsByDistrictForInspection(@PathVariable("district") District district) {
        return applicationService.getAllApplicationsByDistrictForStores(district);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/stores/search/{applicationId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole( 'STORESCLERK')")
    public List<Application> getApplicationsForStoresBySearch(@PathVariable("district") District district, @PathVariable("applicationId") Long applicationId) {
        return applicationService.getApplicationForStoresBySearch(district, applicationId);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/ispresent/{refNo}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole( 'USER')")
    public boolean isPresent(@PathVariable("refNo") String refNo) {
        return applicationService.isRefNoPresent(refNo);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/inspect")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole( 'PROJECTENGINEER')")
    public List<Application> getApplicationsByDistrictForInspection(@PathVariable("district") District district) {
        return applicationService.getApplicationsByDistrictForInspection(district);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/inspect/search/{applicationId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('PROJECTENGINEER')")
    public List<Application> getApplicationsForInspectionBySearch(@PathVariable("district") District district, @PathVariable("applicationId") Long applicationId) {
        return applicationService.getApplicationForInspectionBySearch(district, applicationId);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
//    @GetMapping("/district/{district}/pending")
//    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('PROJECTENGINEER')")
//    public List<Application> getPendingApplicationsByDistrict(@PathVariable("district") District district) {
//        return applicationService.getPendingApplicationsByDistrict(district);
//    }


    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/pending")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('DISTRICTMANAGER')")
    public Page<Application> getPendingApplicationsForDistrict(
            @PathVariable("district") District district,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return applicationService.getPendingApplicationsByDistrict(district, page, size);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/pending/search/{applicationId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('DISTRICTMANAGER')")
    public List<Application> getPendingDistrictApplicationsBySearch(@PathVariable("district") District district, @PathVariable("applicationId") Long applicationId) {
        return applicationService.getPendingDistrictApplicationBySearch(district, applicationId);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/search/{applicationId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('DISTRICTMANAGER')")
    public List<Application> getDistrictApplicationsBySearch(@PathVariable("district") District district, @PathVariable("applicationId") Long applicationId) {
        return applicationService.getDistrictApplicationBySearch(district, applicationId);
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/district/{district}/count")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('DISTRICTMANAGER' , 'STORESCLERK' , 'PROJECTENGINEER')")
    public Map<Status, Long> getApplicationsByDistrictByCount(@PathVariable("district") District district) {
        System.out.println("we are here");
        var applications = applicationService.getNumApplicationsByDistrict(district);

            return applications.stream()
                    .collect(Collectors.groupingBy(Application::getStatus, Collectors.counting()));
    }

    /**
     * Author: Kudakwashe E Koti
     * */
    @GetMapping("/user/{createdby}/count")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('USER')")
    public Map<Status, Long> getApplicationsByCountCreatedBy(@PathVariable("createdby") String createdby) {
        var apps = applicationService.getApplicationByCreatedBy(createdby);
        return apps.stream()
                .collect(Collectors.groupingBy(Application::getStatus, Collectors.counting()));
    }


//    @GetMapping("/user/{email}")
//    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('USER')")
//    public List<Application> getApplicationsByEmail(@PathVariable("email") String email) {
//        return applicationService.getApplicationsByEmail(email);
//    }

    @GetMapping("/region/{region}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('GENERALMANAGER')")
    public List<Application> getApplicationsByRegion(@PathVariable("region") Region region) {
        return applicationService.getApplicationsByRegion(region);
    }

    @PutMapping("approve/{id}/{email}")
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('DISTRICTMANAGER')")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @PathVariable String email, @RequestBody Status status) {
        statusChangeService.updateStatusAndNotify(id, status, email);
        return ResponseEntity.ok("Status updated successfully");
    }

    @GetMapping("/user/{createdby}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('USER')")
    public List<Application> getApplicationsByCreatedBy(@PathVariable("createdby") String createdby) {
        return applicationService.getApplicationByCreatedBy(createdby);
    }

    @GetMapping("/user/{createdby}/{applicationId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('USER')")
    public List<Application> getApplicationsBySearch(@PathVariable("createdby") String createdby, @PathVariable("applicationId") Long applicationId) {
        return applicationService.getApplicationBySearch(createdby, applicationId);
    }

    @GetMapping("/applications/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('USER' , 'DISTRICTMANAGER', 'GENERALMANAGER', 'MANAGINGDIRECTOR', 'STORESCLERK', 'PROJECTENGINEER')")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Application application = applicationService.getApplicationById(id);
        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/applications/pjob/{pjob}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('USER' , 'DISTRICTMANAGER', 'GENERALMANAGER', 'MANAGINGDIRECTOR', 'STORESCLERK', 'PROJECTENGINEER')")
    public ResponseEntity<Application> getApplicationByPjob(@PathVariable String pjob) {
        Application application = applicationService.getApplicationByPjob(pjob);
        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/applications/{applicationId}/line-items/{lineItemId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasAnyRole('PROJECTENGINEER')")
    public ResponseEntity<Application> updateLineItem(
            @PathVariable("applicationId") Long applicationId,
            @PathVariable("lineItemId") Long lineItemId,
            @RequestBody UpdateLineItemRequest request) {

        Application updatedApplication = applicationService.updateLineItem(applicationId, lineItemId, request.getReason(), request.getStatus());
        if (updatedApplication != null) {
            return ResponseEntity.ok(updatedApplication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
