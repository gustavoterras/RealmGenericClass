package com.realmexample.model;

/**
 * Created by Gustavo on 31/01/2017.
 */

public class Filter {

    private int type;
    private String args1;
    private String args2;

    public Filter(int type, String args1, String args2) {
        this.type = type;
        this.args1 = args1;
        this.args2 = args2;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getArgs1() {
        return args1;
    }

    public void setArgs1(String args1) {
        this.args1 = args1;
    }

    public String getArgs2() {
        return args2;
    }

    public void setArgs2(String args2) {
        this.args2 = args2;
    }
}
