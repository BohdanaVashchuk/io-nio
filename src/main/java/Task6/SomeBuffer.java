package Task6;

import Task2.Task2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SomeBuffer {
    public static final Logger LOGGER = LogManager.getLogger(SomeBuffer.class);

    public static void main(String[] args) {
        writeToChanel();
        readFromChannel();

    }

    public static void writeToChanel() {
        try (FileChannel fileChannel = FileChannel.open(Paths.get("test1.txt"), StandardOpenOption.WRITE)) {
            String string = "Some text for adding some text to file";
            ByteBuffer byteBuffer = ByteBuffer.wrap(string.getBytes());
            fileChannel.write(byteBuffer);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
    public static void readFromChannel() {
        String s ="";
        try (FileChannel fileChannel = FileChannel.open(Paths.get("test1.txt"))) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            LOGGER.info("Read data: ");
            while (fileChannel.read(byteBuffer) != -1){
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    s = s + (char) byteBuffer.get();
                }System.out.println(s);
                byteBuffer.clear();
            }
        }catch (Exception e){
            LOGGER.error(e);
        }

    }
}
