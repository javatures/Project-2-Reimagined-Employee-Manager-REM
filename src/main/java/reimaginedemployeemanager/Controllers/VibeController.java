package reimaginedemployeemanager.Controllers;

import java.util.List;
import java.util.Optional;

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

import reimaginedemployeemanager.Objects.Vibe;
import reimaginedemployeemanager.Repositories.VibeRepository;

@CrossOrigin
@RestController
public class VibeController {

    @Autowired
    VibeRepository vibeRepository;

    @RequestMapping(value = "/createVibe", 
                    consumes = MediaType.APPLICATION_JSON_VALUE, 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.POST)
    public void createVibe (@RequestBody Vibe vibe) {

        vibeRepository.save(vibe);

    }

    @RequestMapping(value = "/deleteVibe",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST)
    public void deleteVibe (@RequestBody Vibe vibe) {

        vibeRepository.deleteById(vibe.getVibeID());

    }

    @RequestMapping(value = "/getVibe",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Optional<Vibe>> getVibe (long vibeID) {

        return new ResponseEntity<>(vibeRepository.findById(vibeID), HttpStatus.OK);

    }

    @RequestMapping(value = "/listVibes",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    public ResponseEntity<List<Vibe>> listVibes () {

        return new ResponseEntity<>(vibeRepository.findAll(), HttpStatus.OK);

    }

    /**
     * Performs GET request from endpoint /listVibesByEmployee to retrieve a ResponseEntity that is a List of type Vibe. It is passed an employeeID in order to execute findAllByEmployeeID() from the Vibe Repository, which returns an HttpStatus of OK.
     * 
     * @param employeeID
     * @return
     */
    @RequestMapping(value = "/listVibesByEmployee",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    public ResponseEntity<List<Vibe>> listVibesByEmployee(long employeeID) {

        System.out.println(vibeRepository.findAllByEmployeeID(employeeID).toString());
        return new ResponseEntity<>(vibeRepository.findAllByEmployeeID(employeeID), HttpStatus.OK);
    }
    
}
