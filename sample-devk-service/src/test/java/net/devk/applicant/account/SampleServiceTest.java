package net.devk.applicant.account;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


import net.devk.applicant.ServiceDeployment;
import net.devk.applicant.account.SampleService;
import net.devk.applicant.model.SampleEntity;

@RunWith(Arquillian.class)
public class SampleServiceTest extends ServiceDeployment {
	
	@Inject
	private SampleService sampleService;

	@Test
	public void mustHaveItems() {
		sampleService.createSample();
		List<SampleEntity> allSamples = sampleService.findAll();
		Assert.assertNotEquals(0, allSamples.size());
	}

	@Test
	public void testSayHelloService() {
		final String sayHello = sampleService.sayHello();
		Assert.assertEquals("Hello World !!!!", sayHello);
	}

	@Test(expected = TimeoutException.class)
	public void testTryTimeout() {
		sampleService.tryTimeout();
	}
}