
package net.devk.applicant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SAMPLE")
public class SampleEntity {

	// private static final String SEQUENCE_NAME = "SAMPLE_SEQ";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME,
	// allocationSize = 100)
	private Long id;
	@Column(name = "FIELD_NAME")
	private String sampleField;

	
	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getSampleField() {
		return sampleField;
	}

	public void setSampleField(String sampleField) {
		this.sampleField = sampleField;
	}

}
