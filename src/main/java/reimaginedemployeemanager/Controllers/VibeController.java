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

import reimaginedemployeemanager.Objects.Vibe;
import reimaginedemployeemanager.Repositories.VibeRepository;

import java.util.List;
import java.util.Optional;

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
    public void deleteVibe (@RequestBody long vibeID) {

        vibeRepository.deleteById(vibeID);

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
    
}
