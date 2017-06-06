package com.WindThunderStudio.LogAnalizer.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

public class LogLoader {

    
    public LogLoader() {
        
    }
    
    public void readLogFile(String path, int limit, int readOWrite) {
        if (StringUtils.isNotBlank(path)) {
            File pathFile = new File(path);
            FileReader inReader = null;
            BufferedReader reader = null;
            if (pathFile.exists() && pathFile.isFile()) {
                try {
                    inReader = new FileReader(pathFile);
                    reader = new BufferedReader(inReader);
                    Iterator<String> lineIt = reader.lines().iterator();
                    
                    Analyzer ana = new Analyzer();
                    ana.analyze(lineIt, limit, readOWrite);
                    reader.close();
                    inReader.close();
                } catch (Exception e) {
                    System.err.println(e);
                } 
            }
        }
    }
    
}
