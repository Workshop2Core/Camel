package com.javatrainee.batch27.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class SahamRouteBuilder extends CamelRouteBuilder  {
	@Override
	public void configure() throws Exception {
		
		String mapping = "/workshop2/saham";
		
		/*Get All*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getAll")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getAll");
		
		/*Get Saham By Id Saham*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getSahamByIdSaham/{idSaham}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getSahamByIdSaham/{idSaham}");

		/*get Saham By Saham Name*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getSahamBySahamName/{sahamName}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getSahamBySahamName/{sahamName}");
		
		/*get Saham By Kode Saham*/
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/getSahamByKodeSaham/{kodeSaham}")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/getSahamByKodeSaham/{kodeSaham}");
		
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
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/update/{idSaham}?restletMethod=PUT")
		.process(new Processor() {                          
            @Override
            public void process(Exchange exchange) throws Exception {
            	exchange.getOut().setHeader("Content-type", exchange.getIn().getHeader("Content-type"));
            	exchange.getOut().setHeader("idSaham", exchange.getIn().getHeader("idSaham"));            	
                exchange.getOut().setBody(exchange.getIn().getBody());
            }
        })
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/update/{idSaham}?restletMethod=PUT");
		
		/*Delete*/		
		from ("restlet:http://" + camelIp + ":" + camelPort + mapping +  "/delete/{idSaham}?restletMethod=DELETE")
		.to("restlet:http://" + springCoreIp + ":" + springCorePort + mapping +  "/delete/{idSaham}?restletMethod=DELETE");

	}
}
