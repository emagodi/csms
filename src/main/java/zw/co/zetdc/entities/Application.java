package zw.co.zetdc.entities;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import zw.co.zetdc.enums.*;
import zw.co.zetdc.handlers.BaseEntity;


import java.lang.ref.Reference;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "application")
@EntityListeners(AuditingEntityListener.class)
public class Application extends BaseEntity {


    private String title;
    private String firstname;
    private String lastname;
    private String jobType;
    private String nationalId;
    private String identificationType;
    private String houseNo;
    private String suburb;
    private String depot;
    private String phoneNumber;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ApplicationLineItems> applicationLineItemsList;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String district;
    private String region;
    private String referenceType;
    private String referenceNo;
    private String msg;
    private Long totalPrice;

}
