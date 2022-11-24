package hu.petrik.fuzizsigmond_javafxrestclientdolgozat;

import com.google.gson.annotations.Expose;

public class Animal {
    private int id;
    @Expose
    private String name;
    @Expose
    private int age;
    @Expose
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
