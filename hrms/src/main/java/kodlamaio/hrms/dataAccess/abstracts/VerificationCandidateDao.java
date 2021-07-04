package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerificationCandidate;

public interface VerificationCandidateDao extends JpaRepository<VerificationCandidate, Integer> {

}
