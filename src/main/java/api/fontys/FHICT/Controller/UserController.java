package api.fontys.FHICT.Controller;

import api.fontys.FHICT.Logic.UserLogic;
import api.fontys.FHICT.Model.User;
import api.fontys.FHICT.Response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RequestMapping(value="/user")
@RestController
public class UserController {
    @Autowired
    private UserLogic logic;

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> addUser(@RequestBody User user) {
        try {
            logic.createUser(user);
            RegisterResponse response = new RegisterResponse();
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        }  catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/student/get")
    public ResponseEntity<StudentResponse>getStudent(@RequestBody User user){
        try{
            logic.getStudent(user.getStudentNumber());
            StudentResponse response = new StudentResponse();
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value="/employee/get")
    public ResponseEntity<EmployeeResponse>getEmployee(@RequestBody User user){
        try{
            logic.getStudent(user.getStudentNumber());
            EmployeeResponse response = new EmployeeResponse();
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<RemoveUserResponse>removeUser(@RequestBody User user){
        try{
            logic.deleteUser(user);
            RemoveUserResponse response = new RemoveUserResponse();
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}