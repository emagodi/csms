package zw.co.zetdc.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
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

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;


    @Override
    public void submitApplication(ApplicationRequest applicationRequest) {
        Application application = new Application();

        application.setTitle(applicationRequest.getTitle());
        application.setFirstname(applicationRequest.getFirstname());
        application.setLastname(applicationRequest.getLastname());
        application.setJobType(applicationRequest.getJobType());
        application.setReferenceType(applicationRequest.getReferenceType());
        application.setReferenceNo(applicationRequest.getReferenceNo());
        application.setMsg(applicationRequest.getMsg());
        application.setNationalId(applicationRequest.getNationalId());
        application.setIdentificationType(applicationRequest.getIdentificationType());
        application.setHouseNo(application.getHouseNo());
        application.setSuburb(application.getSuburb());
        application.setDepot(applicationRequest.getDepot());
        application.setPhoneNumber(applicationRequest.getPhoneNumber());
        application.setEmail(applicationRequest.getEmail());
        application.setDistrict(applicationRequest.getDistrict());
        application.setRegion(applicationRequest.getRegion());
        application.setStatus(applicationRequest.getStatus());
        application.setTotalPrice(applicationRequest.getTotalPrice());


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
                .sorted(Comparator.comparing(ApplicationResponse::getUpdatedBy).reversed())
                .collect(Collectors.toList());
    }


    private ApplicationResponse mapToApplicationResponse(Application application) {
        return ApplicationResponse.builder()
                .id(application.getId())
                .title(application.getTitle())
                .firstname(application.getFirstname())
                .lastname(application.getLastname())
                .jobType(application.getJobType())
                .referenceType(application.getReferenceType())
                .referenceNo(application.getReferenceNo())
                .msg(application.getMsg())
                .nationalId(application.getNationalId())
                .identificationType(application.getIdentificationType())
                .houseNo(application.getHouseNo())
                .suburb(application.getSuburb())
                .depot(application.getDepot())
                .phoneNumber(application.getPhoneNumber())
                .email(application.getEmail())
                .district(application.getDistrict())
                .region(application.getRegion())
                .applicationLineItemsList(application.getApplicationLineItemsList())
                .status(application.getStatus())
                .totalPrice(application.getTotalPrice())
                .createdAt(application.getCreatedAt())
                .createdBy(application.getCreatedBy())
                .updatedAt(application.getUpdatedAt())
                .updatedBy(application.getUpdatedBy())
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

    @Override
    public List<Application> getApplicationsByDistrict(District district) {
        return null;
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

    @Override
    public List<Application> getApplicationBySearch(String createdby, Long applicationId) {

        var apps = applicationRepository.getApplicationByCreatedBy(createdby);

        var applications = apps.stream()
                .filter(application -> Objects.equals(application.getId(), applicationId))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed())
                .collect(Collectors.toList());

        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public List<Application> getDistrictApplicationBySearch(District district, Long applicationId) {
        var apps = applicationRepository.findByDistrict(district);

        var applications = apps.stream()
                .filter(application -> Objects.equals(application.getId(), applicationId))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed())
                .collect(Collectors.toList());

        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public Page<Application> getPendingApplicationsByDistrict(District district, int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updatedAt");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Application> applicationsPage = applicationRepository.findByDistrict(district, pageable);

        List<Application> filteredApplications = applicationsPage.getContent().stream()
                .filter(app -> Objects.equals(app.getStatus(), Status.PENDING))
                .collect(Collectors.toList());

        Page<Application> items = new PageImpl<>(filteredApplications,Pageable.unpaged(),filteredApplications.size());

        return new PageImpl<>(filteredApplications, pageable, items.getTotalElements());
    }

//    @Override
//    public List<Application> getPendingApplicationsByDistrict(District district) {
//        return applicationRepository
//                .findByDistrict(district)
//                .stream()
//                .filter(app -> Objects.equals(app.getStatus(), Status.PENDING))
//                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed())
//                .collect(Collectors.toList());
//    }



    @Override
    public List<Application> getPendingDistrictApplicationBySearch(District district, Long applicationId) {
        var apps = applicationRepository.findByDistrict(district);

        var applications = apps.stream()
                .filter(application -> Objects.equals(application.getId(), applicationId))
                .filter(application -> Objects.equals(application.getStatus(), Status.PENDING))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed()).collect(Collectors.toList());
        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public List<Application> getApplicationsByDistrictForInspection(District district) {
        final Set<Status> ALLOWED_STATUSES = EnumSet.of(Status.RECEIVED, Status.INSPECTION_REJECTED, Status.INSPECTION_ACCEPTED);
        var apps = applicationRepository.findByDistrict(district);

        var applications = apps.stream()
                .filter(application -> ALLOWED_STATUSES.contains(application.getStatus()))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed()).collect(Collectors.toList());
        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public List<Application> getApplicationForInspectionBySearch(District district, Long applicationId) {
        final Set<Status> ALLOWED_STATUSES = EnumSet.of(Status.RECEIVED, Status.INSPECTION_REJECTED, Status.INSPECTION_ACCEPTED);
        var apps = applicationRepository.findByDistrict(district);

        var applications = apps.stream()
                .filter(application -> ALLOWED_STATUSES.contains(application.getStatus()))
                .filter(application -> Objects.equals(application.getId(), applicationId))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed()).collect(Collectors.toList());
        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public List<Application> getPendingApplicationsByDistrictForInspection(District district) {
        var apps = applicationRepository.findByDistrict(district);

        var applications = apps.stream()
                .filter(application -> Objects.equals(application.getStatus(), Status.RECEIVED))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed()).collect(Collectors.toList());
        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public List<Application> getPendingApplicationForInspectionBySearch(District district, Long applicationId) {
        var apps = applicationRepository.findByDistrict(district);

        var applications = apps.stream()
                .filter(application -> Objects.equals(application.getId(), applicationId))
                .filter(application -> Objects.equals(application.getStatus(), Status.RECEIVED))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed()).collect(Collectors.toList());
        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public List<Application> getApplicationForStoresBySearch(District district, Long applicationId) {
        var apps = applicationRepository.findByDistrict(district);

        var applications = apps.stream()
                .filter(application -> Objects.equals(application.getId(), applicationId))
                .filter(application -> Objects.equals(application.getStatus(), Status.DISTRICT_APPROVED))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed()).collect(Collectors.toList());
        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public List<Application> getAllApplicationsByDistrictForStores(District district) {
        var apps = applicationRepository.findByDistrict(district);

        var applications = apps.stream()
                .filter(application -> Objects.equals(application.getStatus(), Status.DISTRICT_APPROVED))
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed()).collect(Collectors.toList());
        log.info(String.valueOf(applications.isEmpty()));
        return applications.isEmpty()
                ? Collections.singletonList(Application.builder().email(null).build())
                : applications;
    }

    @Override
    public List<Application> getNumApplicationsByDistrict(District district) {
        return applicationRepository
                .findByDistrict(district)
                .stream()
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed())
                .collect(Collectors.toList());
    }


//    public List<Application> getApplicationsByDistrict(District district) {
//        return applicationRepository
//                .findByDistrict(district)
//                .stream()
//                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed())
//                .collect(Collectors.toList());
//
//    }

    @Override
    public Page<Application> getAllApplicationsByDistrict(District district, int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updatedAt");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Application> applicationsPage = applicationRepository.findByDistrict(district, pageable);

        List<Application> filteredApplications = new ArrayList<>(applicationsPage.getContent());

        Page<Application> pages = new PageImpl<>(filteredApplications, pageable, applicationsPage.getTotalElements());

        return pages;
    }

//    public List<Application> getApplicationsByEmail(String email) {
//        return applicationRepository.findByEmail(email);
//    }

    public List<Application> getApplicationsByRegion(Region region) {
        return applicationRepository
                .findByRegion(region)
                .stream()
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed())
                .collect(Collectors.toList());

    }


    public List<Application> getApplicationByCreatedBy(String createdby){
        return applicationRepository.getApplicationByCreatedBy(createdby)
                .stream()
                .sorted(Comparator.comparing(Application::getUpdatedBy).reversed())
                .collect(Collectors.toList());

    }

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

}
