package pojo.requests.jobs;
import enums.Strength;
import lombok.Getter;
import lombok.Setter;

/**
 * This class contains variables required to set while creating Sharpening job. Getters can be used for validations.
 * Setters and Getters are created using Lombok library to reduce boilerplate code
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class SharpeningJob extends Jobs{

    @Setter
    @Getter
    private Strength strength;
}
