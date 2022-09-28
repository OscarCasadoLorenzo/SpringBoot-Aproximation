package spring.springboot.WebBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PENDANT_BOOK")
public class PendantBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticketID")
    private Integer id;

    @Column(name = "requeststate")
    private String requeststate;

    @Column(name = "service")
    private String service;
}