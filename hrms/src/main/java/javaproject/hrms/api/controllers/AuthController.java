package javaproject.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaproject.hrms.business.abstracts.AuthService;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.Candidate;
import javaproject.hrms.entities.concretes.Employer;

@RestController

@RequestMapping("api/auth")

public class AuthController {

	private AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@RequestBody Candidate candidate, String confirmedPassword) {
		
		return this.authService.registerCandidate(candidate, confirmedPassword);
	}
	
	@PostMapping("/registerEmployer")
	public Result registerCandidate(@RequestBody Employer employer, String confirmedPassword) {
		
		return this.authService.registerEmployer(employer, confirmedPassword);
	}
	
	@GetMapping("/verify")
	public Result verify(int userId, String verificationCode) {
		
		return this.authService.verifyEmail(userId, verificationCode);
	}
	
	
}
