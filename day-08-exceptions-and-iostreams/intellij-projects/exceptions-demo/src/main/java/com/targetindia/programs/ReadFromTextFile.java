package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class ReadFromTextFile {
    public static void main(String[] args) {
        String filename = "./pom.xml";

        FileReader reader = null;

        try{
            reader = new FileReader(filename);
            // a file is open, and the actual job is done by a C++ (native) code
            // which might have allocated memory for its internal work. We can release the memory
            // allocated when we no longer require "reader", by calling (usually) a function called close().
            int ch;

            while((ch = reader.read())!=-1){
                System.out.print((char)ch);
            }
            System.out.println();
        }
        catch(Exception e){
            log.warn("Error!", e);
        }
        finally {
            if(reader!=null){
                try{
                    reader.close();
                }
                catch(IOException e1){
                    log.warn("Error while cloing", e1);
                }
            }
        }
    }
}
