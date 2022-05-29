package pojo.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateWorkflowPojo {

    private String name;
    private String description;

}
