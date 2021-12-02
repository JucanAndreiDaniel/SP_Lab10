package ro.uvt.services;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * JsonFileHandler
 */
public class JsonFileHandler {

    public static void writeToFile(String output)
    {
        String filepath = "lab6_tema/output.json";
        try {

            File file = new File(filepath);
            if(!file.exists())
            { 
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(filepath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(output);
            printWriter.close();
        }
        catch (Exception ex){ ex.printStackTrace(); }
    }
}