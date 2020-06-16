package http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class TypiCodeAPIComments {

    private final String resourceURI_COMMENTS = "https://jsonplaceholder.typicode.com/comments?postId=";

    public List<Comment> getAllComments(Long postId) {
        try {
            URL url = new URL(resourceURI_COMMENTS + postId.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream inputStream = con.getInputStream();
            Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");

            String response = scanner.hasNext() ? scanner.next() : "";
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Comment>>(){}.getType();
            List<Comment> comments = gson.fromJson(response, listType);
            return comments;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
