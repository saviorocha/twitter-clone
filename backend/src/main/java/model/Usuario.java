package model;

import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
	@NotBlank(message = "E-mail não pode estar em branco") private String email;
	private Instant criado;
	private boolean ativado;
}
