package br.com.infoterras.realmmodule.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gustavo on 31/01/2017.
 */

public class Dog extends RealmObject {

    @PrimaryKey
    private String name;
    private String color;

    public Dog() {
    }

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
