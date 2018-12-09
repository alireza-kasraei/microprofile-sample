package net.devk.applicant.account;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;

import net.devk.applicant.account.dto.SampleDTO;
import net.devk.applicant.model.SampleEntity;

@Path("/samples")
public class SampleRestController {

	@Inject
	private SampleService sampleService;

	@Inject
	private ModelMapper modelMapper;

	@PostConstruct
	public void init() {
		modelMapper.addMappings(new PropertyMap<SampleEntity, SampleDTO>() {

			@Override
			protected void configure() {
				map().setId(source.getId());
				map().setSampleField(source.getSampleField());
			}
		});
	}

	@Produces(MediaType.TEXT_PLAIN)
	@Path("/hello")
	@GET
	public Response sayHello() {
		return Response.status(Status.OK).entity(sampleService.sayHello()).build();
	}

	@POST
	public Response createSamples() {
		sampleService.createSample();
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSamples() {
		List<SampleEntity> allSampleEntities = sampleService.findAll();
		java.lang.reflect.Type targetListType = new TypeToken<List<SampleDTO>>() {
		}.getType();
		return Response.status(Status.OK).entity(modelMapper.map(allSampleEntities, targetListType)).build();
	}

}