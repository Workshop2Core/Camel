package com.javatrainee.batch27.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class LoginHistoryRouteBuilder extends CamelRouteBuilder {
	@Override
	public void configure() throws Exception {
		String mapping = "/workshop2/loginHistory";
		
		/*findLoginHistoryByIdUser*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/findLoginHistoryByIdUser/{userid}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping + "/findLoginHistoryByIdUser/{userid}");
			
		/*Delete*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/delete/{id}?restletMethod=DELETE")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/delete/{id}?restletMethod=DELETE");
				
		/*INSERT*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/insert?restletMethod=POST")
		.process(new Processor() {                          
            @Override
            public void process(Exchange exchange) throws Exception {
            	exchange.getOut().setHeader("Content-type", exchange.getIn().getHeader("Content-type"));
                exchange.getOut().setBody(exchange.getIn().getBody());
            }
        })
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/insert?restletMethod=POST");
	
	}
}
