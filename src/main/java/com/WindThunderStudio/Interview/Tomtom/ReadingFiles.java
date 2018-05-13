package com.WindThunderStudio.Interview.Tomtom;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

public class ReadingFiles {
    public File read(String path) {
        if (!path.isEmpty()) {
            File f = new File(path);
            if (f.exists()) {
                return f;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        ReadingFiles reader = new ReadingFiles();
        File file = new File("files\\new.csv");
        URL url = ReadingFiles.class.getResource("/new.csv"); //get project root real path
        File f = reader.read(url.getPath()); //relative path: searching from sys var "user.dir", usually where JVM is invoked. Here is project root.
        //absolute path: searching from system root
        //try with resources: ensure to close resources after use;
        //can have exception and catch block, just same as try {}
        try(BufferedReader bfr = new BufferedReader(new FileReader(f))) { 
            String line = bfr.readLine();
            while ((line = bfr.readLine()) != null && !line.isEmpty()) { //line is available in the second part!
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
