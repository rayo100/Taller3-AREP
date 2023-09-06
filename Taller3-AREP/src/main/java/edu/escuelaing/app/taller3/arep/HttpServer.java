/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.app.taller3.arep;

import edu.escuelaing.app.taller3.arep.spark.*;
import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import org.json.*;

/**
 *
 * @author cv100
 */

public class HttpServer {
    
    private static HttpServer _instance = new HttpServer();

    private HashMap<String, ServiceTwoParam> services = new HashMap<>();
    
    private HashMap<String, Response> responses = new HashMap<>();
    
    private OutputStream outputStream = null;
    
    private StaticFiles staticFiles = StaticFiles.getIstance();

    public void run(String[] args) throws IOException {

        String urlTitle = "";
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while(running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream()));
            String inputLine, outputLine, resource = "", method = "";
            Boolean firstLine = true;
            outputStream = clientSocket.getOutputStream();
            int contentLength = -1;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                if (firstLine) {
                    System.out.println("Inputline: " + inputLine);
                    method = inputLine.split("/")[0].split(" ")[0];
                    resource = "/" + inputLine.split("/")[1].split(" ")[0];
                    firstLine = false;
                }
                
                if (!in.ready()) {
                    break;
                }
            }
            
            System.out.println("Resource: " + resource);
            System.out.println("Method: " + method);
            
            if (services.containsKey(resource)){

                System.out.println("Encontré la llave...");

                if(method.equals("GET")){
                    Response newResponse = new Response();
                    newResponse.setBody(services.get(resource).handle("", newResponse));
                    out.println(newResponse.getType());
                    out.println();
                    out.println(newResponse.getBody());

                } else if (method.equals("POST")){
                    Response newResponse = new Response();
                    newResponse.setBody(services.get(resource).handle("", newResponse));
                    out.println(newResponse.getType());
                    out.println();
                    out.println(newResponse.getBody());
                    responses.put("/" + resource, newResponse);
                }
            }
            
            ServiceTwoParam servicio = null;
            URI requestedUri = null;
            try{
                requestedUri = new URI(resource);
                servicio = findService(resource);
            }catch(URISyntaxException ex){
                
            }
            
            if (servicio != null){
               getServicio(servicio, requestedUri, out);
            } else {
                getFile(resource);
            }
            
            //out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }
    
    /**
     * Method that creates a table in String(JSON) format
     * @param response String movie information
     * @return String(JSON)
     */
    private static String createTable(String response){
        HashMap<String,String> dictionary = new HashMap<String, String>();
        JSONArray jsonArray = new JSONArray(response);
        for (int i=0; i<jsonArray.length();i++){
            JSONObject object = jsonArray.getJSONObject(i);
            for (String key: object.keySet()) {
                dictionary.put(key.toString(), object.get(key).toString());
            }
        }
        String table = "<tr> \n";
        for (String keys: dictionary.keySet()){
            String value = dictionary.get(keys);
            table += "<td>" + keys + "</td>\n";
            table += "<td>" + value + "</td>\n";
            table += "<tr> \n";
        }
        return table;
    }
    
  
    public static String getHello(String uri){
        ///hello?name=Cesar
        String newUri = uri.split("=")[1];
        String response = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: aplication/json\r\n"
                    + "\r\n"
                    + "{ \"msg\": \"Hello " + newUri + " \" }"; //" + uri + "
        return response;
    }

    /**
     * Method createv view html
     * @return view html
     */
    public static String getIndexResponse(){
        return "<!DOCTYPE html>\n" 
                +"<html>\n" 
                +"    <head>\n"
                +"        <center>\n"
                +"            <title>Search Films</title>\n" 
                +"            <meta charset=\"UTF-8\">\n" 
                +"            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                +"        </center>\n"
                +"    </head>\n" 
                +"    <body>\n" 
                +"        <h1>Search Movies</h1>\n"
                +"        <form action=\"/hello\">\n"
                +"            <label for=\"name\">Name:</label><br>\n" 
                +"            <input type=\"text\" id=\"name\" name=\"name\"><br><br>\n" 
                +"            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" 
                +"        </form> \n" 
                +"        <div id=\"getrespmsg\"></div>\n" 
                +"\n" 
                +"        <script>\n" 
                +"            function loadGetMsg() {\n" 
                +"                let nameVar = document.getElementById(\"name\").value;\n" 
                +"                if (nameVar) {\n" 
                +"                   console.log(\"Nombre \" + nameVar)\n" 
                +"                   const xhttp = new XMLHttpRequest();\n"
                +"                   xhttp.onload = function() {\n" 
                +"                       document.getElementById(\"getrespmsg\").innerHTML =\n" 
                +"                       this.responseText;\n" 
                +"                   }\n" 
                +"                   xhttp.open(\"GET\", \"/hello?name=\"+nameVar);\n" 
                +"                   xhttp.send();\n" 
                +"                };\n" 
                +"            }\n" 
                +"        </script>\n" 
                +"\n" 
                +"    </body>\n" 
                +"</html>";
    }
    
    /**
     * Method that returns the server instance
     * @return Instance Server
     */
    public static HttpServer getInstance() {
        return _instance;
    }

    /**
     * Method to register services
     * @param path String path
     * @param service String value
     */
    public void registerService(String path, ServiceTwoParam service) {
        services.put(path, service);
    }
    
    /**
     * Method to find services
     * @param resource String value
     * @return ServiceTwoParam
     */
    public ServiceTwoParam findService(String resource) {
        return services.get(resource);
    }
    

    /**
     * Method that gets the OutputStream
     * @return OutputStream
     */
    public OutputStream getOutputStream() {
        return outputStream;
    }

    private void getServicio(ServiceTwoParam servicio, URI requestedUri, PrintWriter out) throws IOException {
        String header = "";
        Path file = Paths.get(requestedUri.getPath());
        PrintWriter printwriter = new PrintWriter(out, true);
        BufferedReader reader = Files.newBufferedReader(file);
        String line = "";
        String contentType = getContentType(requestedUri);
        boolean sendHeader = true;
        header = "HTTP/1.1 200 OK \r\n"
                + "Content-Type: " + contentType + "\r\n"
                + " \r\n";
        
        printwriter.println(header);
        printwriter.println(servicio.handle(requestedUri.getQuery(), null));
    }

    private String getContentType(URI requestedUri) {
        return "";
    }

    private void getFile(String path) {
        URI requestedUri = null;
        try{
            requestedUri = new URI("target/classes/public" + path);
        }catch(URISyntaxException ex){
        
        }
    }

    
}