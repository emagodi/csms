package zw.co.zetdc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.zetdc.enums.Status;

import java.math.BigDecimal;

@Entity
@Table(name = "application_line_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemCode;
    private String description;
    private Integer quantity;
    private String unitOfMeasure;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String reason;

}