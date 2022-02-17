package api.fontys.FHICT.Repository;

import api.fontys.FHICT.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByStudentNumber(String studentNumber);
    User findByEmployeeNumber(String studentNumber);
}
