package com.WindThunderStudio.LogAnalizer.Logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import com.WindThunderStudio.LogAnalizer.Launcher;

import static com.WindThunderStudio.LogAnalizer.Launcher.*;
public class Analyzer {
    
    private static final String LINE_START_DEBUG = "DEBUG";
    private static final String LINE_START_INFO = "INFO";
    private static final String LINE_START_WARN = "WARN";
    private static final String LINE_START_ERROR = "ERROR";
    private static final String LINE_START_FATAL = "FATAL";
    int start = 6;
    int end = 30;
    private static final String lb = System.lineSeparator();
    public Analyzer() {
        // TODO Auto-generated constructor stub
    }
    
    
    void analyze(Iterator<String> lineIt, int limit, int readOWrite) {
        StringBuilder line = new StringBuilder("");
        StringBuilder lastLine = new StringBuilder("");
        String lineText = "";
        String timeStr = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSSS");
        LocalDateTime date1 = null;
        LocalDateTime date2 = null;
        Duration diff = null;
        long seconds = 0;
        
        line.setLength(0); //clear
        line.append(lineIt.next());
        lineText = line.toString();
        timeStr = line.substring(start, end);
        date1 = formatter.parse(timeStr, LocalDateTime::from);
        
        StringBuilder b = new StringBuilder("");
        while (lineIt.hasNext()) {
            line.setLength(0); //clear
            line.append(lineIt.next());
            lineText = line.toString();
            if (lineText.startsWith(LINE_START_DEBUG) ||
                    lineText.startsWith(LINE_START_ERROR) ||
                    lineText.startsWith(LINE_START_FATAL) ||
                    lineText.startsWith(LINE_START_INFO) ||
                    lineText.startsWith(LINE_START_WARN)) {
                //this line is valid, begin to analyze
                timeStr = line.substring(start, end);
                date2 = formatter.parse(timeStr, LocalDateTime::from);
                if (date1 != null) {
                    diff = Duration.between(date1, date2);
                    seconds = diff.getSeconds();
                    date1 = date2;
                    if (DEBUG) {
                        System.out.println(seconds);
                    }
                    if (readOWrite == Launcher.RUN_ANALYSE) {
                        if (seconds >= limit) {
                            b.append("Time interval: " + seconds).append(lb);
                            b.append(lastLine.toString()).append(lb);
                            b.append(line.toString()).append(lb);
                            b.append(lb);
                        }
                    } else if (readOWrite == Launcher.RUN_ADDTIME) {
                        b.append("Time interval with last methods: " + seconds).append(lb);
                        b.append(line.toString().trim()).append(lb);
                        b.append(lb);
                    }
                    lastLine.setLength(0);
                    lastLine.append(lineText);
                }
            } else {
                continue;
            }
        }
        String fileName = (readOWrite == Launcher.RUN_ANALYSE ? "ANYLYZED" : "TIMEADDED");
        String fullName = "C:\\Users\\99GU6879\\Desktop\\log_result_" + fileName + ".txt";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(fullName);
            bw = new BufferedWriter(fw);
            bw.write(b.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
}
