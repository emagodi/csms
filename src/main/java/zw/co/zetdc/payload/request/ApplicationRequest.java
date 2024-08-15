package zw.co.zetdc.payload.request;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.zetdc.entities.ApplicationLineItems;
import zw.co.zetdc.enums.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicationRequest {


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
