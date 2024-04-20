package zw.co.zetdc.payload.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialRequest {
    private String itemCode;
    private String description;
    private String unitOfMeasure;
    private BigDecimal price;

}
