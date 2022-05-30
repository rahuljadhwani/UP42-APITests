package pojo.requests;

import lombok.Getter;
import lombok.Setter;


/**
 * This class contains variables required while creating Payload Object for Creating Workflows API.
 * Setters and Getters are created using Lombok library to reduce boilerplate code
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

@Setter
@Getter
public class CreateWorkflowPojo {

    private String name;
    private String description;

}
