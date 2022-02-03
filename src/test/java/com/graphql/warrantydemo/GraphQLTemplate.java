package com.graphql.warrantydemo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;

@Component
public class GraphQLTemplate {

    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private TestRestTemplate restTemplate;
    @Value("${graphql.servlet.mapping:/graphql}")
    private String graphqlMapping;

    private ObjectMapper objectMapper = new ObjectMapper();

    private String createJsonQuery(String graphql, ObjectNode variables)
            throws JsonProcessingException {

        ObjectNode wrapper = objectMapper.createObjectNode();
        wrapper.put("query", graphql);
        wrapper.set("variables", variables);
        return objectMapper.writeValueAsString(wrapper);
    }

    private String loadQuery(String location) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + location);
        return loadResource(resource);
    }

    private String loadResource(Resource resource) throws IOException {
        try (InputStream inputStream = resource.getInputStream()) {
            return StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    public GraphQLResponse perform(String graphqlResource, ObjectNode variables, String authToken) throws IOException {
        String graphql = loadQuery(graphqlResource);
        String payload = createJsonQuery(graphql, variables);
        return post(payload, authToken);
    }
    
    private GraphQLResponse post(String payload, String authToken) {
        return postRequest(forJson(payload, authToken));
	}

    
    public GraphQLResponse postForResource(String graphqlResource, String authToken) throws IOException {
    	return perform(graphqlResource, null, authToken);
    }
    
    private GraphQLResponse postRequest(HttpEntity<Object> request) {
        ResponseEntity<String> response = restTemplate.exchange(graphqlMapping, HttpMethod.POST, request, String.class);
        return new GraphQLResponse(response);
    }
    
    private HttpEntity<Object> forJson(String json, String authToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(json, headers);
    }

}
