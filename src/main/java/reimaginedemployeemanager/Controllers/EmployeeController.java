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

import reimaginedemployeemanager.Objects.Employee;
import reimaginedemployeemanager.Repositories.EmployeeRepository;

@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/createEmployeeAccount", 
                    consumes = MediaType.APPLICATION_JSON_VALUE, 
                    produces = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.POST)
    public void createEmployeeAccount (@RequestBody Employee employee) {

        employeeRepository.save(employee);

    }

    @RequestMapping(value = "/deleteEmployeeAccount", 
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.POST)
    public void deleteEmployeeAccount (@RequestBody long employeeID) {

        employeeRepository.deleteById(employeeID);

    }

    @RequestMapping(value = "/findEmployee",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Optional<Employee>> findEmployee (long employeeID) {

        return new ResponseEntity<>(employeeRepository.findById(employeeID), HttpStatus.OK);

    }

    @RequestMapping(value = "/listEmployees",
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listEmployees () {

        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value="/employeeLogin",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Optional<Employee>> employeeLogin(@RequestBody Employee employee) 
	{
		Optional<Employee> employeeDatabase = employeeRepository.findById(employee.getEmployeeID());
		
		if(employeeDatabase.isPresent() && employeeDatabase.get().getPassword().equals(employee.getPassword()) && employeeDatabase.get().getEmail().equals(employee.getEmail()))
			return new ResponseEntity<>(employeeDatabase, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
    
}
