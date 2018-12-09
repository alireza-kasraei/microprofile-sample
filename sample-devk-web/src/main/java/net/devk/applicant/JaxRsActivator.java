package net.devk.applicant;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import net.devk.applicant.account.SampleRestController;

/**
 * A class extending {@link Application} and annotated with @ApplicationPath is
 * the Java EE 7 "no XML" approach to activating JAX-RS.
 * <p>
 * <p>
 * Resources are served relative to the servlet path specified in the
 * {@link ApplicationPath} annotation.
 * </p>
 */
public class JaxRsActivator extends Application {
    /* class body intentionally left blank */

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        resources.add(SampleRestController.class);
        
        // exception mappers
        addExceptionMappers(resources);

        return resources;
    }



    private void addExceptionMappers(Set<Class<?>> resources) {
    }

}
