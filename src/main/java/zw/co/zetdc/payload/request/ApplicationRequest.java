package zw.co.zetdc.payload.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.zetdc.enums.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplicationRequest {

    @Enumerated(EnumType.STRING)
    private Title title;

    private String firstname;
    private String lastname;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    private ReferenceType referenceType;

    private String referenceNo;

    private String msg;

    private String nationalId;

    @Enumerated(EnumType.STRING)
    private IdentificationType identificationType;

    private String address;

    private String phoneNumber;

    private String email;

    private List<ApplicationLineItemsDto> applicationLineItemsDtoList;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private District district;

    @Enumerated(EnumType.STRING)
    private Region region;

    private Long totalPrice;


}
