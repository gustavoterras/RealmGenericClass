package com.realmexample.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gustavo on 31/01/2017.
 */

public class Person extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private int age;
    private RealmList<Dog> dogs;

    public Person() {
    }

    public Person(long id, String name, int age, RealmList<Dog> dogs) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dogs = dogs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public RealmList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(RealmList<Dog> dogs) {
        this.dogs = dogs;
    }
}
