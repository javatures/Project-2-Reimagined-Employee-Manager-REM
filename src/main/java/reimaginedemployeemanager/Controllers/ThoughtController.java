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

import reimaginedemployeemanager.Objects.Thought;
import reimaginedemployeemanager.Repositories.ThoughtRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ThoughtController {

    @Autowired
    ThoughtRepository thoughtRepository;

    @RequestMapping(value = "/createThought", 
                    consumes = MediaType.APPLICATION_JSON_VALUE, 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.POST)
    public void createThought (@RequestBody Thought thought) {

        thoughtRepository.save(thought);

    }

    @RequestMapping(value = "/deleteThought",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST)
    public void deleteThought (@RequestBody long thoughtID) {

        thoughtRepository.deleteById(thoughtID);

    }

    @RequestMapping(value = "/getThought",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Optional<Thought>> getThought (long thoughtID) {

        return new ResponseEntity<>(thoughtRepository.findById(thoughtID), HttpStatus.OK);

    }

    @RequestMapping(value = "/listThoughts",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    public ResponseEntity<List<Thought>> listThoughts () {

        return new ResponseEntity<>(thoughtRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/listThoughtsByEmployee",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    public ResponseEntity<List<Thought>> listThoughtsByEmployee (long employeeID) {

        System.out.println(thoughtRepository.findAllByEmployeeID(employeeID).toString());
        return new ResponseEntity<>(thoughtRepository.findAllByEmployeeID(employeeID), HttpStatus.OK);
    }
    
}
