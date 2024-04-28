import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    Moeda moeda;
    public Moeda requestsApi(String teste) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/33deee192e3d5e63793e6c2a/latest/" + teste)).build();

        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();

            moeda = gson.fromJson(/*teste*/ response.body(), Moeda.class);

            return moeda;


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não encontrado");
        }

    }

}
