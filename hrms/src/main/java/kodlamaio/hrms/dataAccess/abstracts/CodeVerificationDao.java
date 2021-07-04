package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CodeVerification;

public interface CodeVerificationDao extends JpaRepository<CodeVerification, Integer> {
	CodeVerification findByDate(String date);
}
