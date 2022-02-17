package api.fontys.FHICT.Logic;

import api.fontys.FHICT.Exceptions.UserNotFoundException;
import api.fontys.FHICT.Model.User;
import api.fontys.FHICT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogic {

    @Autowired
    private UserRepository repository;

    public void createUser(User user) { repository.save(user);}

    public void deleteUser(User user){
        if(user.getStudentNumber() == null) {
            User a = repository.findByStudentNumber(user.getStudentNumber());
            repository.deleteById(a.getId());
        }
        else {
            User a = repository.findByEmployeeNumber(user.getEmployeeNumber());
            repository.deleteById(a.getId());
        }
    }

    public User getUser(int id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User getStudent(String studentnumber) { return repository.findByStudentNumber(studentnumber);}
    public User getEmployee(String employeenumber) { return repository.findByEmployeeNumber(employeenumber);}
}
