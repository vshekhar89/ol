package app;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * @author vimalendu
 * @date 08/11/2016
 * @version 1.0
 *
 */
@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {

	/**
	 * This method changes the default page size from 20 to 50 
	 * as per client's requirement
	 */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            config.setDefaultPageSize(50);
    }

}
