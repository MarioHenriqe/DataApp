package com.returndata.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @RequestMapping(value = "/")
    public ResponseEntity<String> Index(){
        ClientHttpRequestFactory requestFactory = new
                HttpComponentsClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        String fooResourceUrl = "http://52.154.232.243:8085";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl +"/4", String.class );
        ObjectMapper mapper = new ObjectMapper();

        return response;
    }
}
