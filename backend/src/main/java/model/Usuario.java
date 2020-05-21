package model;

import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long userId;
	@NotBlank(message = "Nome de usuário não pode estar em branco") private String username;
	@NotBlank(message = "Senha não pode estar em branco") private String senha;
	@Email @NotEmpty(message = "E-mail não pode estar em branco") private String email;
	private Instant criado;
	private boolean ativado;
}
