package com.example.demo;

import com.example.demo.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import java.util.Map;

public class Terrasoft extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(Terrasoft.class);

    public LoginCheckResponse loginCheck(String login, String password) {

        ObjectFactory objectFactory = new ObjectFactory();


        LoginCheck request = new LoginCheck();
        request.setLogin(objectFactory.createLoginCheckLogin(login));
        request.setPassword(objectFactory.createLoginCheckPassword(password));


        return (LoginCheckResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/ITerrasoftData/LoginCheck"));
    }


    public GetOfferingInfoForInternetShopResponse getOfferingInfoForInternetShop(int index) {

        ObjectFactory objectFactory = new ObjectFactory();


        GetOfferingInfoForInternetShop request = new GetOfferingInfoForInternetShop();
        request.setIndex(index);



        return (GetOfferingInfoForInternetShopResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback("http://tempuri.org/ITerrasoftData/GetOfferingInfoForInternetShop"));
    }

}