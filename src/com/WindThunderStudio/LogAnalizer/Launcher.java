package com.WindThunderStudio.LogAnalizer;

import java.io.File;
import java.util.Scanner;

import com.WindThunderStudio.LogAnalizer.Logic.LogLoader;

public class Launcher {
    public static final boolean DEBUG = false;
    public static final int RUN_ANALYSE = 1;
    public static final int RUN_ADDTIME = 2;
    public static void main(String[] args) {
        LogLoader loader = new LogLoader();
        if (args == null || args.length == 0) {
            System.out.println("No parameters specified. Please, give these parameters: ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Log file path: ");
            String path = sc.nextLine();
            System.out.println("Time limit: ");
            int limit = sc.nextInt();
            System.out.println("Analyse time interval (1) or add time interval to every line (2): ");
            int mode = sc.nextInt();
            loader.readLogFile(path, limit, mode);
            
        } else if (args.length == 3 && args[0] != null && args[1] != null && args[2] != null){
            try {
                File log = new File(args[0]);
                if (log.exists() && log.isFile()) {
                    loader.readLogFile(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                } else {
                    System.err.println("No such file: " + args[0]);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } else {
            System.err.println("Parameters incorrect. Exit...");
            System.exit(1);
        }
        
        
    }
}
