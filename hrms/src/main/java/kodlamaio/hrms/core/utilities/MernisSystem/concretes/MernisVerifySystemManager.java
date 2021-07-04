package kodlamaio.hrms.core.utilities.MernisSystem.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.Mernis.MernisSystem;
import kodlamaio.hrms.core.utilities.MernisSystem.abstracts.MernisVerifySystemService;

@Service
public class MernisVerifySystemManager implements MernisVerifySystemService {
	MernisSystem mernisSystem = new MernisSystem();
	public boolean verify(String id){
		return mernisSystem.check(id);
	}
}
