package api.fontys.FHICT.Repository;

import api.fontys.FHICT.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findByName(String name);
}
