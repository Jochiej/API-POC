package api.fontys.FHICT.Controller;

import api.fontys.FHICT.Logic.ProjectLogic;
import api.fontys.FHICT.Model.Project;
import api.fontys.FHICT.Model.User;
import api.fontys.FHICT.Response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping(value="/project")
@RestController
public class ProjectController {

    private final ProjectLogic logic;

    @PostMapping(value = "/add")
    public ResponseEntity<addProjectResponse> addProject(@RequestBody Project project) {
        try {
            logic.createProject(project);
            addProjectResponse response = new addProjectResponse();
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        }  catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<UpdateProjectResponse> updateProject(@RequestBody Project project) {
        try {
            logic.updateProject(project);
            UpdateProjectResponse response = new UpdateProjectResponse();
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        }  catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<DeleteProjectResponse> deleteProject(@RequestBody Project project) {
        try{
           logic.deleteProject(project);
            DeleteProjectResponse response = new DeleteProjectResponse();
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value= "/get")
    public ResponseEntity<ProjectReponse>getProject(String name) {
        try{
            ProjectReponse response = new ProjectReponse();
            response.setProject(logic.findProjectByName(name));
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/user/add")
    public ResponseEntity<AddUserToProjectResponse>addUserToProject(Project project, User user){
        AddUserToProjectResponse response = new AddUserToProjectResponse();
        try{
            if(logic.addPersonToProject(project, user) == true){
                response.setSuccess(true);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setSuccess(false);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<DeleteUserFromProjectResponse>removeUserFromProject(Project project, User user) {
        try{
            logic.removePersonFromProject(project, user);
            DeleteUserFromProjectResponse response = new DeleteUserFromProjectResponse();
            response.setSuccess(true);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}