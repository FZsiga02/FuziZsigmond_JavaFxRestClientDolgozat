package hu.petrik.fuzizsigmond_javafxrestclientdolgozat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Animal {
    private int id;
    @Expose
    @SerializedName("Pet's name")
    private String name;
    @Expose
    @SerializedName("Pet's age")
    private int age;
    @Expose
    @SerializedName("Bird")
    private boolean bird;

    public Animal(int id, String name, int age, boolean bird){
        this.id = id;
        this.name = name;
        this.age = age;
        this.bird = bird;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isBird() {
        return bird;
    }

    public void setBird(boolean bird) {
        this.bird = bird;
    }
}
