package reimaginedemployeemanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import reimaginedemployeemanager.Objects.Task;
import reimaginedemployeemanager.Repositories.TaskRepository;

@CrossOrigin
@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/createTask", 
                    consumes = MediaType.APPLICATION_JSON_VALUE, 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.POST)
    public void createTask (@RequestBody Task task) {

        taskRepository.save(task);

    }

    @RequestMapping(value = "/deleteTask",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST)
    public void deleteTask (@RequestBody long taskID) {

        taskRepository.deleteById(taskID);

    }

    @RequestMapping(value = "/getTask",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Optional<Task>> getTask (long taskID) {

        return new ResponseEntity<>(taskRepository.findById(taskID), HttpStatus.OK);

    }

    @RequestMapping(value = "/listTasks",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Task>> listTasks () {

        return new ResponseEntity<>(taskRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/listTasksByEmployee",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Task>> listTasksByEmployee (long employeeID) {

        System.out.println(taskRepository.findAllByEmployeeID(employeeID).toString());
        return new ResponseEntity<>(taskRepository.findAllByEmployeeID(employeeID), HttpStatus.OK);

    }
    
}
