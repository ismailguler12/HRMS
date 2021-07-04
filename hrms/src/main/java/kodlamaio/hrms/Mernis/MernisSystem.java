package kodlamaio.hrms.Mernis;

public class MernisSystem {
	public boolean check(String id) {
		if (id.length() != 11){
			return false;
		}
		else  return true;
	}
}
