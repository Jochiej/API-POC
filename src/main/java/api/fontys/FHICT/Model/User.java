package api.fontys.FHICT.Model;

import api.fontys.FHICT.misc.Role;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Role role;

    @Getter
    @Setter
    private String firstName;

    @Nullable
    @Getter
    @Setter
    private String middleName;

    @Getter
    @Setter
    private String lastName;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @Nullable
    @Getter
    @Setter
    private String employeeNumber;

    @Nullable
    @Getter
    @Setter
    private String studentNumber;

}
