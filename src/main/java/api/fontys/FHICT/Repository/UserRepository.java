package api.fontys.FHICT.Repository;

import api.fontys.FHICT.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByStudentNumber(String studentNumber);
    User findByEmployeeNumber(String studentNumber);
}
