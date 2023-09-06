/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.app.taller3.arep.spark;

import edu.escuelaing.app.taller3.arep.HttpServer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author cv100
 */
public class HttpResponse {

    public static Map<String, Response> gets = new HashMap<>();

    public static void getFile(String path, ServiceTwoParam service) {
        String request = "";
        Response response = new Response();
        String var = service.handle(request, response);
        response.setBody(var);
        response.setPath(path);
        gets.put(path, response);
    }


    public static String getBody(String path) {
        byte[] file;
        try{
            file = Files.readAllBytes(Paths.get("src/main/resources/" + path));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return new String(file);
    }

    public static String getBodyImg(String path) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: image/jpg\r\n"
                + "\r\n";
        BufferedImage bufferedImage = ImageIO.read(new File("src/main/resources" + path));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HttpServer server = HttpServer.getInstance();
        DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        dataOutputStream.writeBytes(response);
        dataOutputStream.write(byteArrayOutputStream.toByteArray());
        return response;
    }

}