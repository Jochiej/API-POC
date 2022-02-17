package api.fontys.FHICT.Response;

import api.fontys.FHICT.Model.Project;
import api.fontys.FHICT.Model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ProjectReponse {
    private boolean success;
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    @Getter
    @Setter
    private Project project;
}
