package Task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        //writeToFileByte();
       // readFromFileByte();
      //  writeToFileCharacter();
        readFromFileCharacter();

    }

    public static void writeToFileByte() {
        try (OutputStream outputStream = new FileOutputStream("test.txt")) {
            String test = "Write to file by byte";
            outputStream.write(test.getBytes());
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void readFromFileByte() {
        try (InputStream inputStream = new FileInputStream("test.txt")) {
            byte[] bytes = inputStream.readAllBytes();
            String string = new String(bytes);
            LOGGER.info("text from file: " + string);

        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void writeToFileCharacter(){
        try (Writer writer = new FileWriter("test1.txt")){
            String text = "Some text for writing in the file";
            writer.write(text);
        } catch (Exception e){
            LOGGER.error(e);
        }
    }

    public static void readFromFileCharacter(){
        try(Reader reader = new FileReader("test1.txt")) {
            int data = reader.read();
            String s = "";
            while(data != -1){
                char dataChar = (char) data;
                s = s + dataChar;
                data = reader.read();
            }
            LOGGER.info("here is a text from file " + s);
        }catch (Exception e){
            LOGGER.error(e);
        }
    }
}
