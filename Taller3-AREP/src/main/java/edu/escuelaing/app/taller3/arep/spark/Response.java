/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.app.taller3.arep.spark;

import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author cv100
 */
public class Response {

    private String body, path, type;

    public String getHeader() {
        return "HTTP/1.1 200 \r\n" 
               + "Content-Type: " + type + " \r\n"
               + "\r\n";
    }

    public String getBody() {
        byte[] file;
        try{
            file = Files.readAllBytes(Paths.get("src/main/resources/" + path));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return new String(file);
    }
    
    public void setBody(String body) {
        this.body = body;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponse() {
        return getHeader() + getBody();
    }
}
