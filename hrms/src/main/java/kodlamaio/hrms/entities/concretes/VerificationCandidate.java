package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="verification_candidates")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCandidate {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="candidateId")
	private int candidateId;
}