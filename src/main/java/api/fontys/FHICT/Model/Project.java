package api.fontys.FHICT.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Project {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @Column(unique = true)
    @Getter
    @Setter
    private String projectName;

    @Getter
    @Setter
    private String projectDescription;

    @OneToMany
    @Getter
    @Setter
    private List<User> Participants;

    @Getter
    @Setter
    private Date startDate;

    @Getter
    @Setter
    private Date endDate;
}
