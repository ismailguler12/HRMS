package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "job")
@Entity
@Data
public class Job {
	
	@Id
	@Column(name = "job_id")
	private int id;
	
	@Column(name = "job_name")
	private String jobName;

}
