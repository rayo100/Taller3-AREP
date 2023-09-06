/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.app.taller3.arep.webapps;

import edu.escuelaing.app.taller3.arep.HttpServer;
import edu.escuelaing.app.taller3.arep.spark.HttpResponse;
import java.io.IOException;

/**
 *
 * @author cv100
 */
public class App {

    public static void main(String[] args) throws IOException {

        HttpServer serverInstance = HttpServer.getInstance();
        
        //Get
        serverInstance.registerService("/helloGet", (request, response) -> {
            response.setType("text/html");
            return "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "   <body>\n"
                    + "       <h1>Funciona correctamente el GET</h1>\n"
                    + "   </body>\n"
                    + "</html>\n";
        });
        
        //Post
        serverInstance.registerService("/helloPost", (request, response) -> {
            response.setType("text/html");
            return "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "   <body>\n"
                    + "       <h1>Funciona correctamente el POST</h1>\n"
                    + "   </body>\n"
                    + "</html>\n";
        });
        
        //JSON
        serverInstance.registerService("/pruebaJSON", (request, response) -> {
            response.setType("application/json");
            return "{\n" 
                    + "  \"id\": 2168836,\n" 
                    + "  \"nombre\": \"Cesar Vasquez\",\n" 
                    + "  \"correoElectronico\": \"cesar.vasquez-m@mail.escuelaing.edu.co\",\n" 
                    + "  \"edad\": 21,\n"                
                    + "}\n";
           
        });
        
        serverInstance.run(args);
    }
}
