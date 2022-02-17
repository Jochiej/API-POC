package api.fontys.FHICT.Repository;

import api.fontys.FHICT.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findByProjectName(String name);
}
