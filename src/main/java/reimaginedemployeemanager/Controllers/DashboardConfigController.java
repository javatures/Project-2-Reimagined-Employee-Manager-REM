package reimaginedemployeemanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reimaginedemployeemanager.Objects.DashboardConfig;
import reimaginedemployeemanager.Repositories.DashboardConfigRepository;
import java.util.Optional;

@CrossOrigin
@RestController
public class DashboardConfigController {
    
    @Autowired
    DashboardConfigRepository dcRepository;

    @RequestMapping(value = "/saveDashboardColor", 
                    consumes = MediaType.APPLICATION_JSON_VALUE, 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.POST)
    public void saveDashboardColor (@RequestBody DashboardConfig dc) {

        dcRepository.save(dc);
        System.out.println(dc.toString());
    }

    @RequestMapping(value = "/getDashboardColor", 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.GET)
    public ResponseEntity<Optional<DashboardConfig>>  getDashboardColor (DashboardConfig dc) {

        return new ResponseEntity<>(dcRepository.findById(dc.getEmployeeID()), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateDashboardColor", 
                    consumes = MediaType.APPLICATION_JSON_VALUE, 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.POST)
    public void updateDashboardColor (@RequestBody DashboardConfig dc) {


        Optional<DashboardConfig> updateDC = dcRepository.findById(dc.getEmployeeID());
        
        if (updateDC.isPresent()) {
            
           updateDC.get().setRed(dc.getRed());
           updateDC.get().setGreen(dc.getGreen());
           updateDC.get().setBlue(dc.getBlue());
           dc = updateDC.get();
           dcRepository.save(dc);
        }


    }




}
