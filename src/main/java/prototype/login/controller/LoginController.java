package prototype.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import prototype.login.message.Constant;
import prototype.login.model.User;
import prototype.login.service.UserService;

@RestController
public class LoginController {

	private static final String LOGIN = "/login";
	
	private final UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(LOGIN)
	public ResponseEntity<String> login(@RequestBody @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			throw new IllegalArgumentException(Constant.INVALID_USER);
		}
		return (userService.login(user) == true) ? new ResponseEntity<String>(HttpStatus.OK) 
				: new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}
	
}
