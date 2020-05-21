package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.RegistroRequest;
import lombok.AllArgsConstructor;
import server.AuthService;

@Controller
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	public ResponseEntity<String> signUp(@RequestBody RegistroRequest registroReq) {
		authService.signUp(registroReq);
		return new ResponseEntity<String>("Registro feito com sucesso!", HttpStatus.OK);
	}
}
