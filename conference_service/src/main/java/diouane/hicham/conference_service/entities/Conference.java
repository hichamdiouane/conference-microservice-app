package diouane.hicham.conference_service.entities;

import diouane.hicham.conference_service.model.Keynote;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long keynoteId;
    private String titre;
    private TypeConference type;
    private Date date;
    private int duree;
    private int nb_inscrits;
    private Double score;
    @Transient private Keynote keynote;

}
