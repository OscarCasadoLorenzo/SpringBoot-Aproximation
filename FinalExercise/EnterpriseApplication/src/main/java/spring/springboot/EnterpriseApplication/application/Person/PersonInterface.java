package spring.springboot.EnterpriseApplication.application.Person;

import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.PersonOutputDTO;
import java.util.List;

public interface PersonInterface {

    List<PersonOutputDTO> getAllPersons();

    PersonOutputDTO getPersonByID(Integer id);

    PersonOutputDTO postPerson(PersonInputDTO personInputDTO);

    PersonOutputDTO updatePerson(Integer id, PersonInputDTO personaInputDTO);

    PersonOutputDTO deletePerson(Integer id);
}
