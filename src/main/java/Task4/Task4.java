package Task4;

import Task3.ReadJavaFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Task4 {
    public static final Logger LOGGER = LogManager.getLogger(Task4.class);
    public static void main(String[] args) {
        contentOfDirectory();
    }
    public static void contentOfDirectory(){
        File file = new File("C:\\Users\\Bohdana_Vashchuk\\Desktop\\Project");
        File[] files = file.listFiles();
        for (File object: files) {
            if(object.isFile()){
                LOGGER.info("File name: " + object.getName() + " File size in bytes: " + object.length());
            }
            else if(object.isDirectory()){
                LOGGER.info("Directory name is: " + object.getName() + " Directory size in bytes: " + object.length());
            }
        }
    }
}
