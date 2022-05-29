package pojo.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class AddWorkflowTaskPojo {
    @Setter
    @Getter
    List<Tasks> taskList = new LinkedList();


    public void createWorkflowTasks() {
        Tasks task1 = new Tasks();
        task1.setName("nasa-modis:1");
        task1.setParentName(null);
        task1.setBlockId("ef6faaf5-8182-4986-bce4-4f811d2745e5");

        Tasks task2 = new Tasks();
        task2.setName("sharpening:1");
        task2.setParentName("nasa-modis:1");
        task2.setBlockId("e374ea64-dc3b-4500-bb4b-974260fb203e");

        taskList.add(task1);
        taskList.add(task2);

    }




}
