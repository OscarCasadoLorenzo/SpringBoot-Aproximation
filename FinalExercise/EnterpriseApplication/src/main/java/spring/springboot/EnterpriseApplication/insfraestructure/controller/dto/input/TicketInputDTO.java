package spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TicketInputDTO {
    @NotNull(message = "PersonID property is required.")
    private Integer personID;

    @NotNull(message = "TripID property is required.")
    private Integer tripID;
}
