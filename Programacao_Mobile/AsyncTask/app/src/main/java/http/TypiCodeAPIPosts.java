package http;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import entities.Post;

public class TypiCodeAPIPosts {

    private final String resourceURI_POSTS = "https://jsonplaceholder.typicode.com/posts";

    public List<Post> getAllPosts() {
        try {
            URL url = new URL(resourceURI_POSTS);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream inputStream = con.getInputStream();
            Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");

            String response = scanner.hasNext() ? scanner.next() : "";
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Post>>(){}.getType();
            List<Post> posts = gson.fromJson(response, listType);
            return posts;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
