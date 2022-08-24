package Task3;

import Task1.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class ReadJavaFile {
    public static final Logger LOGGER = LogManager.getLogger(ReadJavaFile.class);

    public static void main(String[] args) {
        readNameFromCommand();
    }
    public static void readNameFromCommand() {
        LOGGER.info("Enter java file name: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.next();
        String line;

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            LOGGER.info( "Your comments are:");
            while ((line = in.readLine()) != null)
            {
                if (line.startsWith("//"))
                    LOGGER.info( line);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
