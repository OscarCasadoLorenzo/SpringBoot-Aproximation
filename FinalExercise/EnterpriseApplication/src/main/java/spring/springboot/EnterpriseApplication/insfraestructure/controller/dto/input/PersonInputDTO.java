package spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class PersonInputDTO {
    @NotBlank(message = "DNI property is required.")
    @Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "DNI property dont have correct syntax.")
    private String dni;

    @NotBlank(message = "Email property is required.")
    @Email(message = "Email property dont have correct syntax.")
    private String email;

    @NotBlank(message = "Password property is required.")
    private String password;

    @NotBlank(message = "Name property is required.")
    @Size(min = 3, message = "Name property should have at least 3 characters.")
    private String name;

    @NotBlank(message = "Surname property is required.")
    @Size(min = 3, message = "Surname property should have at least 3 characters.")
    private String surname;

    @NotBlank(message = "Phone number property is required.")
    @Pattern(regexp="^[0-9]{9}", message = "Phone property dont have correct syntax.")
    private String phone;
}
