/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
/**
 *
 * @author jahaziel
 */
public class Request {
    
    public String getAll() throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpGet getRequest = new HttpGet("http://localhost:8080/api/v1/pedido");
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);
            return apiOutput;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public String getById(String id) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpGet getRequest = new HttpGet("http://localhost:8080/api/v1/pedido/" + id);
            HttpResponse response = httpClient.execute(getRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }

            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);
            return apiOutput;
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public void save(String emp) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost postRequest = new HttpPost("http://localhost:8080/api/v1/pedido");
            postRequest.addHeader("content-type", "application/json");
            StringEntity userEntity = new StringEntity(emp);
            postRequest.setEntity(userEntity);
            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public void update(String producto, String id) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPut putRequest = new HttpPut("http://localhost:8080/api/v1/pedido/" + id);
            putRequest.addHeader("content-type", "application/json");
            StringEntity userEntity = new StringEntity(producto);
            putRequest.setEntity(userEntity);
            HttpResponse response = httpClient.execute(putRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public void delete(String id) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        try {
            HttpDelete deleteRequest = new HttpDelete("http://localhost:8080/api/v1/pedido/" + id);
            HttpResponse response = httpClient.execute(deleteRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

}
