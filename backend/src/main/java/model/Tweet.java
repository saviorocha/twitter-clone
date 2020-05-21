package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long tweetId;
	@NotEmpty private String text;
	@ManyToOne(fetch = FetchType.LAZY)@JoinColumn(name = "userId", referencedColumnName = "userId") private Usuario usuario;
}
