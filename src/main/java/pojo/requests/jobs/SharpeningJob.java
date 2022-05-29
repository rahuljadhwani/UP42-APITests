package pojo.requests.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import enums.Strength;
import lombok.Getter;
import lombok.Setter;

public class SharpeningJob extends Jobs{

    @Setter
    @Getter
    private Strength strength;
}
