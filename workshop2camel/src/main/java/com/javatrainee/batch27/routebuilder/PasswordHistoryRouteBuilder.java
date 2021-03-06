package com.javatrainee.batch27.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class PasswordHistoryRouteBuilder extends CamelRouteBuilder {

	@Override
	public void configure() throws Exception {
		String mapping = "/workshop2/pwdHistory";
		
		/*findByIdPass*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/findByIdPass/{iduser}/{password}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/findByIdPass/{iduser}/{password}");

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
	

	}
}
