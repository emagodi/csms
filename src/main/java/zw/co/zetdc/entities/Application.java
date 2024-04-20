package zw.co.zetdc.entities;


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

    @Enumerated(EnumType.STRING)
    private Title title;
    private String firstname;
    private String lasttname;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    private String nationalId;
    @Enumerated(EnumType.STRING)
    private IdentificationType identificationType;
    private String address;
    private String phoneNumber;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ApplicationLineItems> applicationLineItemsList;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private District district;
    @Enumerated(EnumType.STRING)
    private Region region;
    @Enumerated(EnumType.STRING)
    private ReferenceType referenceType;
    private String referenceNo;
    private String msg;
    private Long totalPrice;

}
