package com.WindThunderStudio.JavaFilePermission;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FilePermissionTester {
    public static void main( String[] args ) throws IOException {
        File file = new File("Y:\\CtrlRecau_WinSuite_DYL\\documentos\\Winsuite-Wincreta-Siltra-Liq. Directa\\CEL\\xxxxx.txt");
        System.out.println( "exists:"  + file.exists() );
        System.out.println( "is file:"  + file.isFile() );
        System.out.println( "can read:" + file.canRead() );
        System.out.println( "can execute:" + file.canExecute() );
        System.out.println( "can write:" + file.canWrite() );
        System.out.println( "is hidden:" + file.isHidden() );
        
        System.out.println("change it to be unreadable, and it works? " + file.setReadable(false));
        System.out.println( "can read:" + file.canRead() );
        System.out.println("change it to be writable, and it works? " + file.setWritable(true));
        System.out.println( "can write:" + file.canWrite() );
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read();
        fileInputStream.close();

    }

}
