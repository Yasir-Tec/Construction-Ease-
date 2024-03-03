package constuction.project.data.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import construction.project.data.dto.LoginDto;
import construction.project.data.dto.OtpDto;
import construction.project.data.dto.ResetDto;
import construction.project.data.dto.ResisterDto;
import construction.project.data.service.ContractorService;

import constuction.project.data.Repository.ContractorRepository;
import constuction.project.data.beans.Contractor;
import constuction.project.data.exception.ResourceNotFoundException;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/services/")
public class ContractorController  {
	
	
	@Autowired
	private ContractorRepository CRepo;
	
	

	@Autowired
	private ContractorService cservice;
	
	
	@GetMapping("/contractors")
	public List<Contractor> getContractorData()
	{
		
		return CRepo.findAll();
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> resister(@RequestBody ResisterDto resisterdto) {
		return new ResponseEntity<String>(cservice.resister(resisterdto), HttpStatus.OK);
	}
	
	@PutMapping("/verifyotp")
	public ResponseEntity<String> verifyAccount(@RequestBody OtpDto dto) {
		System.out.println("IN VERIFICATION METHOD");
		System.out.println(dto.getEmail()+" "+dto.getOtp()+"of v account");
		return new ResponseEntity<String>(cservice.verifyAccount(dto.getEmail(),dto.getOtp()), HttpStatus.OK);
	}

	@PutMapping("/regenerate-otp/{email}")
	public ResponseEntity<String> regenerateOtp(@PathVariable String email) {
		return new ResponseEntity<>(cservice.regenerateOtp(email), HttpStatus.OK);
	}

	@PutMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDto logindto) {
		return new ResponseEntity<>(cservice.login(logindto), HttpStatus.OK);
	}
	
	@PutMapping("/forgot-password/{email}")
	public ResponseEntity<String>forgotPassword(@PathVariable String email){
		System.out.println(email);
	return new ResponseEntity<>(cservice.forgotPassword(email),HttpStatus.OK);
	}
	
	@PutMapping("/reset-password")
	public ResponseEntity<?> resetPassword(@RequestBody ResetDto resetDto)
	{
		cservice.resetPassword(resetDto.getEmail(),resetDto.getPassword());
		return ResponseEntity.ok("Password Reset Done");
	}

	

    @GetMapping("/contractors/{id}")
    public ResponseEntity<Contractor> getContractorById(@PathVariable long id){
        Contractor con = CRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(con);
    }


    @PutMapping("/contractors/{id}")
    public ResponseEntity<Contractor> updateContractor(@PathVariable long id,@RequestBody Contractor contractordetails) {
        Contractor updatecontractor = CRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updatecontractor.setUsername(contractordetails.getUsername());
        updatecontractor.setPassword(contractordetails.getPassword());
        updatecontractor.setEmail(contractordetails.getEmail());
        updatecontractor.setMobile(contractordetails.getMobile());
       

        CRepo.save(updatecontractor);

        return ResponseEntity.ok(updatecontractor);
    }


    @DeleteMapping("/contractors/{id}")
    public ResponseEntity<HttpStatus> deleteContractor(@PathVariable long id){

    	Contractor con = CRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        CRepo.delete(con);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}