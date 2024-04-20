package zw.co.zetdc.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaterialResponse {
    private Long id;
    private String itemCode;
    private String description;
    private String unitOfMeasure;
    private BigDecimal price;
}
