package spring.springboot.SpringSecurity.Persona.infraestructure.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.SpringSecurity.Persona.domain.PersonService;
import spring.springboot.SpringSecurity.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.SpringSecurity.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/login")
    public String loginRoute(
            @RequestBody ObjectNode request
    ){
        return personService.login(request.get("user").asText(), request.get("password").asText());
    }

    @GetMapping
    public List<PersonaOutputDTO> getPersonsRoute(){
        List<PersonaOutputDTO> personaOutputDTOList = personService.getAllPersons();
        return personaOutputDTOList;
    }

    @GetMapping("/name/{name}")
    public List<PersonaOutputDTO> getPersonByNameRoute(@PathVariable String name){
         return personService.getPersonsByName(name);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonByIDRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        PersonaOutputDTO personaOutputDTO = personService.getPersonByID(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public PersonaOutputDTO postPersonRoute(@RequestBody PersonaInputDTO personaInputDTO){
        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonRoute(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return  new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        PersonaOutputDTO personaOutputDTO = personService.updatePerson(id, personaInputDTO);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return  new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        PersonaOutputDTO personaOutputDTO = personService.deletePerson(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }
}
