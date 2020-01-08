package com.returndata.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.telemetry.Duration;
import com.microsoft.applicationinsights.telemetry.Telemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@Controller
public class IndexController {

    @Autowired
    TelemetryClient telemetryClient = new TelemetryClient();



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> Index(){
        ClientHttpRequestFactory requestFactory = new
                HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        String fooResourceUrl = "http://52.154.232.243:8085";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl +"/4", String.class );
        ObjectMapper mapper = new ObjectMapper();

        Duration duration = new Duration(1);

        telemetryClient.trackDependency("game-cluster-v1-dns-b3a04279.hcp.centralus.azmk8s.io:8085", "GET", duration, true);
        return response;
    }
}
