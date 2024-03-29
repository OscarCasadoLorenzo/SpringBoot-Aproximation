package spring.springboot.EnterpriseApplication.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TICKET")
public class TicketEntity {
    @Id
    @Column(name="ticketID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="tripID")
    private TripEntity tripEntity;

    @ManyToOne
    @JoinColumn(name="personID")
    private PersonEntity personEntity;

    public TicketEntity(TripEntity tripEntity, PersonEntity personEntity){
        this.tripEntity = tripEntity;
        this.personEntity = personEntity;
    }

    public void updateEntity(TripEntity tripEntity, PersonEntity personEntity){
        this.tripEntity = tripEntity;
        this.personEntity = personEntity;
    }
}
