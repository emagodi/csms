package zw.co.zetdc.payload.request;

import lombok.Builder;

@Builder
public record MailBody(String to, String subject, String text){

}
