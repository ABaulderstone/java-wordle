package dictionary;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Dictionary {
  private String baseUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/";  
  private final HttpClient client = HttpClient.newHttpClient(); 
  
  

  public boolean checkWordExists(String word) throws IOException, InterruptedException{
    HttpResponse<String> response = this.makeRequest(word);
   return response.statusCode() == 200;
  }

  public String getDefinition(String word) throws IOException, InterruptedException, ParseException {
    HttpResponse<String> response = this.makeRequest(word);
    JSONParser parser = new JSONParser();
    JSONArray data = (JSONArray) parser.parse(response.body());
    JSONObject results = (JSONObject) data.get(0);
    JSONObject meanings = (JSONObject) ((JSONArray) results.get("meanings")).get(0);
    JSONObject firstDefintion = (JSONObject) ((JSONArray) meanings.get("definitions")).get(0);
    String defintion =  firstDefintion.get("definition").toString();
    return defintion;
    

  }
  

  private HttpResponse<String> makeRequest(String word) throws IOException, InterruptedException {
    URI uri = URI.create(this.baseUrl + word);
    HttpRequest request = HttpRequest.newBuilder(uri).build();
    return this.client.send(request, BodyHandlers.ofString());
  }


}
