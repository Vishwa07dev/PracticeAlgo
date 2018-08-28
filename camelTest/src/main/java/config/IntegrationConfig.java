package config;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;

public class IntegrationConfig  extends CamelConfiguration{
	
	@Override
	public List<RouteBuilder> routes() {
		
		List<RouteBuilder> routeList = new ArrayList<RouteBuilder>();
		
		routeList.add(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
        
		return routeList;
	}

}
