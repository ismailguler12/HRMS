package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateVerifyService;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.CodeVerificationDao;
import kodlamaio.hrms.entities.concretes.VerificationCandidate;
import kodlamaio.hrms.entities.concretes.CodeVerification;

@Service
public class CandidateVerifyManager implements CandidateVerifyService {
	private VerificationCandidateDao verificationCandidateDao;
	private CodeVerificationDao codeVerificationDao;
	
	public CandidateVerifyManager () {
		
	}
	
	@Autowired
	public CandidateVerifyManager(VerificationCandidateDao verificationCandidateDao, CodeVerificationDao verificationCodeDao) {
		super();
		this.verificationCandidateDao = verificationCandidateDao;
		this.codeVerificationDao = verificationCodeDao;
	}

	@Override
	public String createCode() {
		Random r = new Random();
		 return "xyz"+String.valueOf(r.nextInt(100)+700)+ "abc";
	}
	
	public void addCode(int candidateId) {
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
		Date date = new Date(System.currentTimeMillis());
		
		CodeVerification verificationCode = new CodeVerification();
		verificationCode.setCode(createCode());
		verificationCode.setVerified(false);
		verificationCode.setDate(format.format(date)); // db ekleme tarih ayarla
		codeVerificationDao.save(verificationCode);
		
		VerificationCandidate verificationCandidate = new VerificationCandidate();
		verificationCandidate.setCandidateId(candidateId);
		verificationCandidate.setId(codeVerificationDao.findByDate(format.format(date)).getId());
		verificationCandidateDao.save(verificationCandidate);
	}
	
}
