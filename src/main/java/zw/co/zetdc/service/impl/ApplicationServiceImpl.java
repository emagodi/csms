package zw.co.zetdc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.zetdc.entities.Application;
import zw.co.zetdc.entities.ApplicationLineItems;
import zw.co.zetdc.enums.District;
import zw.co.zetdc.enums.Region;
import zw.co.zetdc.enums.Status;
import zw.co.zetdc.payload.request.ApplicationRequest;
import zw.co.zetdc.payload.request.ApplicationLineItemsDto;
import zw.co.zetdc.payload.response.ApplicationResponse;
import zw.co.zetdc.repository.ApplicationRepository;
import zw.co.zetdc.service.ApplicationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;


    @Override
    public void submitApplication(ApplicationRequest applicationRequest) {
        Application application = new Application();

        application.setTitle(applicationRequest.getTitle());
        application.setFirstname(applicationRequest.getFirstname());
        application.setLasttname(applicationRequest.getLastname());
        application.setJobType(applicationRequest.getJobType());
        application.setReferenceType(applicationRequest.getReferenceType());
        application.setReferenceNo(applicationRequest.getReferenceNo());
        application.setMsg(applicationRequest.getMsg());
        application.setNationalId(applicationRequest.getNationalId());
        application.setIdentificationType(applicationRequest.getIdentificationType());
        application.setAddress(applicationRequest.getAddress());
        application.setPhoneNumber(applicationRequest.getPhoneNumber());
        application.setEmail(applicationRequest.getEmail());
        application.setDistrict(applicationRequest.getDistrict());
//        application.setRegion(applicationRequest.getRegion());
        application.setStatus(applicationRequest.getStatus());
        application.setTotalPrice(applicationRequest.getTotalPrice());



        // Determine the corresponding region based on the district
        Region region = applicationRequest.getDistrict().getRegion();
        // Set the region in the application
        application.setRegion(region);



        List<ApplicationLineItems> applicationLineItems = applicationRequest.getApplicationLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        application.setApplicationLineItemsList(applicationLineItems);
        applicationRepository.save(application);

    }

    private ApplicationLineItems mapToDto(ApplicationLineItemsDto applicationLineItemsDto) {
        ApplicationLineItems applicationLineItems = new ApplicationLineItems();

        applicationLineItems.setItemCode(applicationLineItemsDto.getItemCode());
        applicationLineItems.setDescription(applicationLineItemsDto.getDescription());
        applicationLineItems.setQuantity(applicationLineItemsDto.getQuantity());
        applicationLineItems.setUnitOfMeasure(applicationLineItemsDto.getUnitOfMeasure());
        applicationLineItems.setPrice(applicationLineItemsDto.getPrice());
        applicationLineItems.setStatus(applicationLineItemsDto.getStatus());
        applicationLineItems.setReason(applicationLineItems.getReason());

        return applicationLineItems;
    }


    public List<ApplicationResponse> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        return applications.stream()
                .map(this::mapToApplicationResponse)
                .collect(Collectors.toList());
    }


    private ApplicationResponse mapToApplicationResponse(Application application) {
        return ApplicationResponse.builder()
                .id(application.getId())
                .title(application.getTitle())
                .firstname(application.getFirstname())
                .lasttname(application.getLasttname())
                .jobType(application.getJobType())
                .referenceType(application.getReferenceType())
                .referenceNo(application.getReferenceNo())
                .msg(application.getMsg())
                .nationalId(application.getNationalId())
                .identificationType(application.getIdentificationType())
                .address(application.getAddress())
                .phoneNumber(application.getPhoneNumber())
                .email(application.getEmail())
                .district(application.getDistrict())
                .region(application.getRegion())
                .applicationLineItemsList(application.getApplicationLineItemsList())
                .status(application.getStatus())
                .totalPrice(application.getTotalPrice())
                .build();
    }


    @Override
    public Application approve(Application application) {
        Application existingApplication = applicationRepository.findById(application.getId()).get();
        existingApplication.setStatus(application.getStatus());
        existingApplication.setMsg(application.getMsg());
        Application aproveApplication = applicationRepository.save(existingApplication);
        return aproveApplication;
    }


    public Application updateLineItem(Long applicationId, Long lineItemId, String reason, Status status) {
        Application existingApplication = applicationRepository.findById(applicationId).orElse(null);
        if (existingApplication != null) {
            List<ApplicationLineItems> existingLineItems = existingApplication.getApplicationLineItemsList();
            for (ApplicationLineItems existingLineItem : existingLineItems) {
                if (existingLineItem.getId().equals(lineItemId)) {
                    existingLineItem.setReason(reason);
                    existingLineItem.setStatus(status);
                    break;
                }
            }

            Application updatedApplication = applicationRepository.save(existingApplication);
            return updatedApplication;
        }
        return null; // or throw an exception if the application is not found
    }







    public List<Application> getApplicationsByDistrict(District district) {
        return applicationRepository.findByDistrict(district);
    }

//    public List<Application> getApplicationsByEmail(String email) {
//        return applicationRepository.findByEmail(email);
//    }

    public List<Application> getApplicationsByRegion(Region region) {
        return applicationRepository.findByRegion(region);
    }


    public List<Application> getApplicationByCreatedBy(String createdby){
        return applicationRepository.getApplicationByCreatedBy(createdby);
    }

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

}
