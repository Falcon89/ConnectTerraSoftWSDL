package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.client.support.interceptor.PayloadValidatingInterceptor;

import java.util.Arrays;

@Configuration
public class Config {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.demo.wsdl");
        return marshaller;
    }

    @Bean
    public Terrasoft quoteClient(Jaxb2Marshaller marshaller) {
        Terrasoft client = new Terrasoft();
        client.setDefaultUri("http://82.207.107.237:35053/TerrasoftDataService/TerrasoftData.svc");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}