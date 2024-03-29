package spring.springboot.Logger;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController("/c1")
public class Controller {

    @RequestMapping("/")
    public String index (){
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Messsage");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
}
