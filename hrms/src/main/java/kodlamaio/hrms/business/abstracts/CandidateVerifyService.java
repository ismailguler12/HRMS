package kodlamaio.hrms.business.abstracts;

public interface CandidateVerifyService {
	public String createCode();
	public void addCode(int candidateId);
}
