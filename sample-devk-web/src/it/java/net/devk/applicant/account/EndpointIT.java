package net.devk.applicant.account;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.provider.jsrjsonp.JsrJsonpProvider;
import org.junit.Test;

public class EndpointIT {

	@Test
	public void testGetProperties() {
		String port = System.getProperty("liberty.test.port");
		String war = System.getProperty("war.name");
		String url = "http://localhost:" + port + "/" + war + "/";
		Client client = ClientBuilder.newClient();
		client.register(JsrJsonpProvider.class);
		WebTarget target = client.target(url + "/rest/samples/hello");
		Response response = target.request().get();
		assertEquals("Incorrect response code from " + url, Response.Status.OK.getStatusCode(), response.getStatus());
		String responseValue = response.readEntity(String.class);
		assertEquals("Hello World !!!!", responseValue);
		response.close();
	}

}
