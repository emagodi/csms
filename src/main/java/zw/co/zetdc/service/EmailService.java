package zw.co.zetdc.service;

import zw.co.zetdc.payload.request.MailBody;

public interface EmailService {
    public void sendSimpleMessage(MailBody mailBody);
}
