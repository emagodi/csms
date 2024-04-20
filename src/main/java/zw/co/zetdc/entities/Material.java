package zw.co.zetdc.entities;

import jakarta.persistence.*;
import lombok.*;
import zw.co.zetdc.handlers.BaseEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "materials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Material extends BaseEntity {

    private String itemCode;
    private String description;
    private String unitOfMeasure;
    private BigDecimal price;

}


