package reimaginedemployeemanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reimaginedemployeemanager.Objects.DashboardConfig;
import reimaginedemployeemanager.Repositories.DashboardConfigRepository;

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
}
