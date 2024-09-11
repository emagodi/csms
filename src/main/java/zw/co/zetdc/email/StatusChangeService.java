//package zw.co.zetdc.email;
//
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Service;
//import zw.co.zetdc.entities.Application;
//import zw.co.zetdc.enums.Status;
//import zw.co.zetdc.repository.ApplicationRepository;
//
//import java.util.Optional;
//
//@Service
//public class StatusChangeService {
//    private final ApplicationRepository applicationRepository;
//    private final ApplicationEventPublisher eventPublisher;
//    private final EmailService emailService;
//
//    public StatusChangeService(ApplicationRepository applicationRepository, ApplicationEventPublisher eventPublisher, EmailService emailService) {
//        this.applicationRepository = applicationRepository;
//        this.eventPublisher = eventPublisher;
//        this.emailService = emailService;
//    }
//
//    public void updateStatusAndNotify(Long id, Status status, String email) {
//        Optional<Application> optionalApplication = applicationRepository.findById(id);
//        if (optionalApplication.isPresent()) {
//            Application application = optionalApplication.get();
//
//            // Update the status
//            application.setStatus(status);
//            // Save the updated application entity
//            applicationRepository.save(application);
//
//            // Publish the status changed event
//            StatusChangedEvent event = new StatusChangedEvent(this, email, status.toString());
//            eventPublisher.publishEvent(event);
//
//            // Send email notification
//            emailService.sendStatusChangeNotification(email, status.toString());
//        }
//    }
//}