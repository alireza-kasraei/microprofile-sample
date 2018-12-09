package net.devk.applicant.account;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devk.applicant.account.SampleRepository;
import net.devk.applicant.model.SampleEntity;

/**
 * 
 *
 */
@ApplicationScoped
class SampleServiceImpl implements SampleService {

	private final Logger log = LoggerFactory.getLogger(SampleServiceImpl.class);

	@Inject
	private SampleRepository sampleRepository;

	@Inject
	@ConfigProperty(name = "hello-message", defaultValue = "Hello !")
	private String helloMessage;

	@Override
	public String sayHello() {
		return helloMessage;
	}

	@Override
	@Transactional
	public void createSample() {
		SampleEntity sampleEntity = new SampleEntity();
		sampleEntity.setSampleField(UUID.randomUUID().toString());
		sampleRepository.save(sampleEntity);
	}

	@Override
	public List<SampleEntity> findAll() {
		return sampleRepository.findAll();
	}

	@Timeout(value = 2, unit = ChronoUnit.SECONDS)
	@Override
	public void tryTimeout() {
		log.info("Block Opertation Started!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		log.info("This part will not be executed");
	}

}
