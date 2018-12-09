package net.devk.applicant.account;

import java.util.List;

import net.devk.applicant.model.SampleEntity;

/**
 * public API for our sample service
 */
public interface SampleService {

	public String sayHello();

	public void createSample();

	public List<SampleEntity> findAll();

	public void tryTimeout();

}
