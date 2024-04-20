package zw.co.zetdc.payload.request;


import lombok.*;
import zw.co.zetdc.enums.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateLineItemRequest {

    private String reason;
    private Status status;

}
