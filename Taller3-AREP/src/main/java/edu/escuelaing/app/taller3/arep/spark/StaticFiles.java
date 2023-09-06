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

public class StaticFiles {

    private static StaticFiles _instance = new StaticFiles();

    private String folder = "src/main/resources";
    
    private final String defauldFolder = "src/main/resources";
    
    public static StaticFiles getIstance() {
        return _instance;
    }

    public void setFolder(String path) {
        folder = defauldFolder + path;
    }

    public String readFile(String path) {
        byte[] file;
        try{
            file = Files.readAllBytes(Paths.get(folder + path));
        }catch (IOException e){
            return "404";
        }
        return new String(file);
    }

    public String getHeader(String type) {
        return "HTTP/1.1 200 \r\n"
               + "Content-Type: " + type + " \r\n" 
               + "\r\n";
    }

}