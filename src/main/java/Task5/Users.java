package Task5;

import java.io.Serializable;

public class Users implements Serializable {
    private String name;
    private int age;
    private Credentials credentials;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", credentials=" + credentials +
                '}';
    }

    public Users(String name, int age, Credentials credentials) {
        this.name = name;
        this.age = age;
        this.credentials = credentials;
    }
}
