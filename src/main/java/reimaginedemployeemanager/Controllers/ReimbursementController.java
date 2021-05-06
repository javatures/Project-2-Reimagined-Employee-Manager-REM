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

import reimaginedemployeemanager.Objects.Reimbursement;
import reimaginedemployeemanager.Repositories.ReimbursementRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ReimbursementController {

    @Autowired
    ReimbursementRepository reimbursementRepository;

    @RequestMapping(value = "/createReimbursement", 
                    consumes = MediaType.APPLICATION_JSON_VALUE, 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.POST)
    public void createReimbursement (@RequestBody Reimbursement reimbursement) {

        reimbursementRepository.save(reimbursement);

    }


    @RequestMapping(value = "/getReimbursement",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Optional<Reimbursement>> getReimbursement (long reimbursementID) {

        return new ResponseEntity<>(reimbursementRepository.findById(reimbursementID), HttpStatus.OK);

    }

    @RequestMapping(value = "/listReimbursement",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    public ResponseEntity<List<Reimbursement>> listReimbursement () {

        return new ResponseEntity<>(reimbursementRepository.findAll(), HttpStatus.OK);

    }
    
    @RequestMapping(value = "/listReimbursementsByEmployee",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    public ResponseEntity<List<Reimbursement>> listReimbursementsByEmployee (long employeeID) {

        return new ResponseEntity<>(reimbursementRepository.findByEmployeeID(employeeID), HttpStatus.OK);

    }

    @RequestMapping(value="/approveReimbursement", 
                    consumes=MediaType.APPLICATION_JSON_VALUE, 
                    produces=MediaType.APPLICATION_JSON_VALUE, 
                    method=RequestMethod.POST)
    public void updateEmployeeManager(@RequestBody Reimbursement reimbursement) {
        Optional<Reimbursement> updateReimbursement = reimbursementRepository.findById(reimbursement.getReimbursementID());

        if (updateReimbursement.isPresent()) {
            updateReimbursement.get().setApproved("true");
            updateReimbursement.get().setApprovalDate(reimbursement.getApprovalDate());

            reimbursement = updateReimbursement.get();

            reimbursementRepository.save(reimbursement);
        }

    }
}
