package com.javatrainee.batch27.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class UserRouteBuilder extends CamelRouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		String mapping = "/workshop2/User";
		
		/*Get All*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getall")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getall");
		
		/*Get By Id*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/findById/{id}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/findById/{id}");

		/*findByUsernameAndPassword*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/findByUsernameAndPassword/{username}/{password}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/findByUsernameAndPassword/{username}/{password}");
		
		/*Insert*/	
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/insert?restletMethod=POST")
		.process(new Processor() {                          
            @Override
            public void process(Exchange exchange) throws Exception {
            	exchange.getOut().setHeader("Content-type", exchange.getIn().getHeader("Content-type"));            	       
                exchange.getOut().setBody(exchange.getIn().getBody());
            }
        })
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/insert?restletMethod=POST");
		
		
		/*Update*/	
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/update/{id}?restletMethod=PUT")
		.process(new Processor() {                          
            @Override
            public void process(Exchange exchange) throws Exception {
            	exchange.getOut().setHeader("Content-type", exchange.getIn().getHeader("Content-type"));
            	exchange.getOut().setHeader("id", exchange.getIn().getHeader("id"));            	
                exchange.getOut().setBody(exchange.getIn().getBody());
            }
        })
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/update/{id}?restletMethod=PUT");
		
		/*Delete*/		
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/delete/{id}?restletMethod=DELETE")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/delete/{id}?restletMethod=DELETE");

	}

}
