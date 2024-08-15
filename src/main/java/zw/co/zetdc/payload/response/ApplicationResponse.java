package zw.co.zetdc.payload.response;


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

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {

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
    private List<ApplicationLineItems> applicationLineItemsList;
    private Status status;
    private String district;
    private String region;
    private String referenceType;
    private String referenceNo;
    private String msg;
    private Long totalPrice;


    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;


}
