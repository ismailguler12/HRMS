	package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateVerifyService;
import kodlamaio.hrms.core.utilities.MernisSystem.abstracts.MernisVerifySystemService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private MernisVerifySystemService mernisVerifySystemService;
	private CandidateVerifyService candidateVerifyService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateVerifyService candidateVerifyService,
			MernisVerifySystemService mernisVerifySystemService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisVerifySystemService = mernisVerifySystemService;
		this.candidateVerifyService = candidateVerifyService;
	}

	@Override
	public DataResult <List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if(this.candidateDao.findByEmail(candidate.getEmail()) != null ) {
			return new ErrorResult("this email already exist");
		}
		else if(this.candidateDao.findByNationalId(candidate.getNationalId())!=null) {
			return new ErrorResult("this ID number already exist");
		}
		else if(this.mernisVerifySystemService.verify(candidate.getNationalId()) == false  ) {
			return new ErrorResult("this Id number is false");
		}
		
		this.candidateDao.save(candidate);
		
		Candidate cand = candidateDao.findByNationalId(candidate.getNationalId());
		
		this.candidateVerifyService.addCode(cand.getId());
		return new SuccessResult("dear "+candidate.getFirstName()+" you have succesfully signed up");
	}
}