package net.devk.applicant;

import java.io.File;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

@ArquillianSuiteDeployment
public class ServiceDeployment {

	@Deployment(name = "service", order = 1)
	public static WebArchive createDeployment() {

		WebArchive archive = ShrinkWrap.create(WebArchive.class, "serviceDev.war");
		File[] libs = Maven.configureResolver().fromFile("src/test/resources/test-settings.xml")
				.loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().resolve().withTransitivity().asFile();

		archive.addAsLibraries(libs);
		archive.setWebXML("test-web.xml");
		archive.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		archive.addAsResource("test-log4j2.xml", "log4j2.xml");
		archive.addAsResource("test-persistence.xml", "META-INF/persistence.xml");
		archive.addAsResource("test-microprofile-config.properties", "META-INF/microprofile-config.properties");

		archive.addPackages(true, EntityManagerFactoryBean.class.getPackage());

		return archive;
	}

}