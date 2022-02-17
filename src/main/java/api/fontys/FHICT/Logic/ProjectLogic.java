package api.fontys.FHICT.Logic;


import api.fontys.FHICT.Model.Project;
import api.fontys.FHICT.Model.User;
import api.fontys.FHICT.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectLogic {

    @Autowired
    private ProjectRepository repository;

    public void createProject(Project project) { repository.save(project);}

    public void deleteProject(Project project) {
        Project a = repository.findByName(project.getProjectName());
        repository.deleteById(a.getId());
    }

    public void updateProject(Project project) { repository.save(project);}

    public Project findProjectByName(String name){return repository.findByName(name);}

    public boolean addPersonToProject(Project project, User user) {
        List<User> participants = project.getParticipants();
        if(participants.contains(user)){
            return false;
        }
        else {
            participants.add(user);
            project.setParticipants(participants);
            return true;
        }
    }
    public void removePersonFromProject(Project project, User user){
        List<User>participants = project.getParticipants();
        participants.remove(user);
        project.setParticipants(participants);
    }
}
