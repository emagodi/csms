//package zw.co.zetdc.email;
//
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmailNotificationListener implements ApplicationListener<StatusChangedEvent> {
//    private final EmailService emailService;
//
//    public EmailNotificationListener(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    @Override
//    public void onApplicationEvent(StatusChangedEvent event) {
//        String recipientEmail = event.getRecipientEmail();
//        String status = event.getStatus();
//
//        // Send status change notification via email
//        emailService.sendStatusChangeNotification(recipientEmail, status);
//    }
//}
