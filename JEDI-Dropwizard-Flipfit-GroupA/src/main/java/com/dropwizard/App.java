package com.dropwizard;

import com.flipfit.rest.HelloTestRest;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.flipkart.rest.EmployeeRESTController;
//import com.flipkart.rest.HelloRestController;

/**s
 * Hello world!
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
          e.jersey().register(new HelloTestRest());
        //  e.jersey().register(new AdminGMSRESTService());
        //e.jersey().register(new CustomerGMSRESTService());
        // e.jersey().register(new GymOwnerGMSRESTService());
        //e.jersey().register(new UserGMSRESTService());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}