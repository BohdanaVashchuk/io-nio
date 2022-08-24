package Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Task2 {
    public static final Logger LOGGER = LogManager.getLogger(Task2.class);
    public static void main(String[] args) {
//        writeToFileByte();
//        readFromFileByte();
//        writeToFileByteWithBuffer();
        readFromFileByteBuffer();
    }
    public static void writeToFileByte() {
        long startTime = System.currentTimeMillis();
        try (OutputStream outputStream = new FileOutputStream("test.txt")) {
            String test = "Write to file by byte ";
            outputStream.write(test.getBytes());
        } catch (Exception e) {
            LOGGER.error(e);
        }
        long endTime = System.currentTimeMillis();
        long seconds = (endTime - startTime) / 1000;
        LOGGER.info("Running time of adding file without buffer is " + seconds + "seconds");
    }

    public static void readFromFileByte() {
        long startTime = System.currentTimeMillis();
        try (InputStream inputStream = new FileInputStream("file10mb.pdf")) {
//            byte[] bytes = inputStream.readAllBytes();
            int data = inputStream.read();
            while (data != -1) {
                data = inputStream.read();
            }
//            String string = new String(bytes);
//            LOGGER.info("text from file: " + string);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        long endTime = System.currentTimeMillis();
        long seconds = (endTime - startTime) / 1000;
        LOGGER.info("Running time of reading file without buffer is " + seconds + "seconds");
    }

    public static void writeToFileByteWithBuffer() {
        long startTime = System.currentTimeMillis();
        try (OutputStream outputStream = new FileOutputStream("test.txt");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream))
        {
            String test = "Write to file by byte ";
            outputStream.write(test.getBytes());
        } catch (Exception e) {
            LOGGER.error(e);
        }
        long endTime = System.currentTimeMillis();
        long seconds = (endTime - startTime) / 1000;
        LOGGER.info("Running time of adding data with buffer is " + seconds + "seconds");
    }

    public static void readFromFileByteBuffer() {
        long startTime = System.currentTimeMillis();
        try (InputStream inputStream = new FileInputStream("file10mb.pdf");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {
            int data = inputStream.read();
            while (true) {
                byte b = dataInputStream.readByte();
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
        long endTime = System.currentTimeMillis();
        long seconds = (endTime - startTime) / 1000;
        LOGGER.info("Running time of reading file with buffer is " + seconds + "seconds");
    }

}
