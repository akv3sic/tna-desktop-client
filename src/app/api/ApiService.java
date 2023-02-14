package app.api;

import java.io.IOException;

public interface ApiService {
    String getUser(int id) throws IOException;
    String getLocations(String jsonBody) throws IOException;
}
