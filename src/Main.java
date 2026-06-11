import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Main{

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static final HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
    private static HttpResponse<Object> response;

    public static void fetch(){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "posts/3"))
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        try{

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != 200) {

                System.err.println("Errore critico, il serever ha risposro con lo status code: " + response.statusCode());
                return;
            } else {

                System.out.println(response.body() + "\nPlyaload ricevuto con successo!");
            }
        } catch(Exception e){

            System.err.println("Fallimento di rete o interruzione del thread: " + e.getMessage());
        }
    }

    public static void post(){

        String jsonPlayLoad = """
        {
            "title": "Studiare Spring Boot",
            "body": "Capire controller, service e repository",
            "userId": 7
        }
        """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "posts"))
                .timeout(Duration.ofSeconds(5))
                .POST(HttpRequest.BodyPublishers.ofString(jsonPlayLoad))
                .build();

        try{

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:\n" + response.body());
        } catch(Exception e){

            System.err.println("Fallimento di rete o interrusione del thread: " + e.getMessage()
                    + "\n" + e.getStackTrace()
                    + "\nResponse Code: " + response.statusCode());
        }
    }
    public static void main(String[] args){

        System.out.println(BASE_URL);
        post();
        fetch();
    }
}