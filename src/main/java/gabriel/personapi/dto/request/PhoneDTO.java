package gabriel.personapi.dto.request;

import gabriel.personapi.enums.PhoneType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class PhoneDTO {
   
    private Long id;

    @NotEmpty
    @Size(min = 10, max = 15)
    private String number;

    
    @NotNull
    private PhoneType type;

}
