package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.File;

public class DisplayTreeOfFiles {
    public static void main(String[] args) {
        // String path = KeyboardUtil.getString("Enter a filesystem path: ");
        String path = "/Users/vinod/Desktop/react-projects/react-simple-phonebook/";
        File file = new File(path);

        if (!file.exists()) {
            System.out.printf("Invalid path - %s%n", path);
            System.exit(1);
        }

        if(!file.isDirectory()){
            System.out.printf("'%s' is not a directory%n", path);
            System.exit(2);
        }

        tree(file, 0);
    }

    static String spaces(int level){
        int size = level*4;
        StringBuffer sb = new StringBuffer(size);
        for(int i=0; i<size; i++){
            sb.append(" ");
        }
        return sb.toString();
    }

    static void tree(File file, int level){
        if(file.getName().startsWith(".")){
            return;
        }
        System.out.printf("%s└─ %s%n", spaces(level) , file.getName());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f: files){
                tree(f, level+1);
            }
        }
    }
}
