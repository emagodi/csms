package zw.co.zetdc.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.zetdc.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationLineItemsDto {
    private Long id;
    private String itemCode;
    private String description;
    private Integer quantity;
    private String unitOfMeasure;
    private BigDecimal price;
    private Status status;
    private String reason;

    private Integer totalQuantity;
    private BigDecimal itemTotalPrice;
    private String currency;

    private Integer receivedQuantity;
    private Integer approvedQuantity;
    private Integer rejectedQuantity;
    private Integer pendingQuantity;
    private LocalDate deliveryDate;
}
