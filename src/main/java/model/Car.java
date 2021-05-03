package model;

public class Car {
    private String name;
    private int curIndex;

    public Car() {}

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurIndex() {
        return curIndex;
    }

    public void setCurIndex(int curIndex) {
        this.curIndex = curIndex;
    }
}
