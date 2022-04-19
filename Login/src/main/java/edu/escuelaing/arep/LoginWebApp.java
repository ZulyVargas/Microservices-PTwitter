package edu.escuelaing.arep;

import static spark.Spark.*;

import java.util.concurrent.atomic.AtomicReference;

import com.google.gson.Gson;

public class LoginWebApp {

    public static void main(String[] args) {

        AtomicReference<String> actualUser = new AtomicReference<>();

        // Inicialización de usuarios registrados
        User user1 = new User("User1", "de7d0966dd91649474ecd891568e59977165c1d80a745a2e62599ec810b8c551");
        User user2 = new User("User2", "3a09990e3ab649f1c81c22d21c9a52f6f889632f41db9987e1d9c043626dd7d3");
        User user3 = new User("User3", "056f0753b4fa50c639811bd7500b2f3f5af973911a9da8e640f98769afa645f7");
        RegisteredUsers registeredUsers = new RegisteredUsers();
        registeredUsers.AddNewUser(user1);
        registeredUsers.AddNewUser(user2);
        registeredUsers.AddNewUser(user3);

        System.out.println("Initiating server... READY");
        port(getPort());

        staticFiles.location("/");

        get("/App", (req, res) -> {
            res.redirect("/login.html");
            res.status(200);
            return null;
        }); 

        get("/login/:user/:password", (req,res)->{
            System.out.println("Ingrese al login ");
            System.out.println("User "+ req.params(":user"));
            System.out.println("Password "+ req.params(":password"));
            boolean found = registeredUsers.IsRegistered(req.params(":user"),req.params(":password"));
            if(found) actualUser.set(req.params(":user"));
        return new Gson().toJson(found);
        });
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
