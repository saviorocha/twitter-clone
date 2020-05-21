package model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "token")
public class VerificationToken {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@OneToOne(fetch = FetchType.LAZY) private Usuario usuario;
	private String token;
	private Instant expiryDate;
}
