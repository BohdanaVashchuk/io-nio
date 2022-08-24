package Task5;

import Task4.Task4;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        serialize();
        deserialize();

    }

    public static void serialize() {
        Users user = new Users("Dana", 34, new Credentials("test", "test1"));
        try (OutputStream outputStream = new FileOutputStream("file.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(user);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public static void deserialize() {
        try (InputStream inputStream = new FileInputStream("file.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Users user = (Users) objectInputStream.readObject();
            LOGGER.info(user.toString());
            LOGGER.info(user.getName());
            LOGGER.info(user.getAge());
            LOGGER.info(user.getCredentials());
        } catch (Exception e) {
            LOGGER.error(e);
        }

    }
}
