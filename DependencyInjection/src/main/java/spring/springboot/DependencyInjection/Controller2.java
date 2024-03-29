package spring.springboot.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController ("/c2")
public class Controller2
{
    @Autowired
    @Qualifier("standardBean")
    PersonService personService;

    @Autowired
    CityService cityService;

    @GetMapping("/controller2/getPerson")
    PersonService addPerson (){
        personService.setAge(personService.getAge()*2);
        return personService;
    }
    @GetMapping("/controller2/getCities")
    List<City> getCities (){
        return cityService.getCities();
    }

}
