package server;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dto.RegistroRequest;
import lombok.AllArgsConstructor;
import model.NotificationEmail;
import model.Usuario;
import model.VerificationToken;
import respository.UserRepository;
import respository.VerificationTokenRepository;

@AllArgsConstructor
@Service
public class AuthService {
	
	private final PasswordEncoder passEncoder;
	private final UserRepository userRepo;
	private final VerificationTokenRepository verificationTokenRepo;
	private final MailService mailService;
	                                                   
	@Transactional                                     
	public void signUp(RegistroRequest registroReq) {  
		Usuario user = new Usuario();                  
		user.setUsername(registroReq.getUsername());   
		user.setSenha(registroReq.getSenha());
		user.setEmail(registroReq.getEmail());
		user.setCriado(Instant.now());
		user.setAtivado(false);
		
		userRepo.save(user);
		String token = generateVerificationToken(user);
		mailService.sendMail(new NotificationEmail(
				"Please activate your account", user.getEmail(),
				"Thank you for signing up to Spring Reddit, please click on the below url to activate " +
				"your account: http://localhost:8080/api/auth/accountVerification/" + token
			));
	}

	private String generateVerificationToken(Usuario user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUsuario(user);
		
		verificationTokenRepo.save(verificationToken);
		return token;
	}
}
