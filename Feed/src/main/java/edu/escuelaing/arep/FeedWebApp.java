package edu.escuelaing.arep;

import static spark.Spark.*;

import com.google.gson.Gson;

public class FeedWebApp {

    public static void main(String[] args) {

        Feed feed = new Feed();
        
        System.out.println("Initiating server... READY");
        port(getPort());

        get("/getFeed", (req, res) -> {
            res.status(200);
            res.type("application/json");

            return new Gson().toJson(feed.getPosts());
        }); 

    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
