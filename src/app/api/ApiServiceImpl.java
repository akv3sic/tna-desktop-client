package app.api;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiServiceImpl implements ApiService {
    private final OkHttpClient client;
    private final String baseUrl;

    private ApiServiceImpl(String baseUrl) {
        this.client = new OkHttpClient();
        this.baseUrl = baseUrl;
    }

    private static ApiServiceImpl instance = null;


    public static ApiServiceImpl getInstance() {
        if (instance == null) {
            instance = new ApiServiceImpl("baseurlstring");
        }
        return instance;
    }



    @Override
    public String getUser(int id) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl + "/users/" + id)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }

            return response.body().string();
        }
    }

    @Override
    public String getLocations(String jsonBody) throws IOException {
        return null;
    }


    // Implement other API methods as needed
}
