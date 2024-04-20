package zw.co.zetdc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasAnyRole('DISTRICTMANAGER' , 'GENERALMANAGER', 'MANAGINGDIRECTOR' , 'STORESCLERK' , 'PROJECTENGINEER')")
    public ResponseEntity<Application> approve(@PathVariable("id") Long id, @RequestBody Application application){
        application.setId(id);
        Application approve = applicationService.approve(application);

        return new ResponseEntity<>(approve, HttpStatus.OK);
    }


    @GetMapping("/district/{district}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasAnyRole('DISTRICTMANAGER' , 'STORESCLERK' , 'PROJECTENGINEER')")
    public List<Application> getApplicationsByDistrict(@PathVariable("district") District district) {
        return applicationService.getApplicationsByDistrict(district);
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
