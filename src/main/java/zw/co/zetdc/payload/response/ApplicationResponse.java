package zw.co.zetdc.payload.response;


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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {

    private Long id;
    private Title title;
    private String firstname;
    private String lasttname;
    private JobType jobType;
    private String nationalId;
    private IdentificationType identificationType;
    private String address;
    private String phoneNumber;
    private String email;
    private List<ApplicationLineItems> applicationLineItemsList;
    private Status status;
    private District district;
    private Region region;
    private ReferenceType referenceType;
    private String referenceNo;
    private String msg;
    private Long totalPrice;


}
