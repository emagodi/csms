package zw.co.zetdc.payload.request;


import lombok.*;
import zw.co.zetdc.enums.Status;
import zw.co.zetdc.enums.StoresStatus;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateLineItemRequest {

    private String reason;
    private Status status;

    private Integer receivedQuantity;
    private Integer approvedQuantity;
    private Integer rejectedQuantity;
    private Integer pendingQuantity;
    private LocalDate deliveryDate;
    private StoresStatus storesStatus;

}
