package spring.springboot.EnterpriseApplication.insfraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.EnterpriseApplication.application.Ticket.TicketService;
import spring.springboot.EnterpriseApplication.domain.PendantBookEntity;
import spring.springboot.EnterpriseApplication.exceptions.UnprocesableException;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.TicketOutputDTO;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/backenterprise/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Value("${eureka.instance.instance-id}")
    private String customerServiceID;

    @GetMapping
    public List<TicketOutputDTO> getAllTicketsRoute(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public TicketOutputDTO getTicketByIDRoute(@PathVariable Integer id){
        return ticketService.getTicketByID(id);
    }

    @GetMapping("/reserve/{destination}")
    public List<TicketOutputDTO> getTicketsByDestinationRoute(
            @PathVariable String destination,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inferiorDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> superiorDate,
            @RequestParam(required = false) Optional<Integer> inferiorHour,
            @RequestParam(required = false) Optional<Integer> superiorHour

    ){
        return ticketService.getTicketsByDestination(destination, inferiorDate, superiorDate, inferiorHour, superiorHour);
    }

    @PostMapping
    public TicketOutputDTO postTicketRoute(@Valid @RequestBody TicketInputDTO ticketInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors, "Ticket");

        PendantBookEntity reserveRequest = new PendantBookEntity(ticketInputDTO.getTripID(), ticketInputDTO.getPersonID(), customerServiceID);
        return ticketService.postTicket(reserveRequest);
    }

    @PutMapping("/{id}")
    public TicketOutputDTO updateTicketRoute(@PathVariable Integer id, @Valid @RequestBody TicketInputDTO ticketInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors, "Ticket");
        return ticketService.updateTicket(id, ticketInputDTO);
    }

    @DeleteMapping("/{id}")
    public TicketOutputDTO deleteTicketRoute(@PathVariable Integer id){
        return ticketService.deleteTicket(id);
    }
}
