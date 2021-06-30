package org.example;

public class Passenger {
private  int pClass;
private int survived;
private String name;
private int sex;
private float age;
private int sibsp;
private int parch;
private String ticket;
private float fare;
private String Cabin;
private String embarked;
private String boat;
private String body;
private String home_dest;

    public Passenger(int pClass, int survived, String name, int sex, float age, int sibsp, int parch, String ticket, float fare, String cabin, String embarked, String boat, String body, String home_dest) {
        this.pClass = pClass;
        this.survived = survived;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibsp = sibsp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        Cabin = cabin;
        this.embarked = embarked;
        this.boat = boat;
        this.body = body;
        this.home_dest = home_dest;
    }


    public int getpClass() {
        return pClass;
    }

    public void setpClass(int pClass) {
        this.pClass = pClass;
    }

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public int getSibsp() {
        return sibsp;
    }

    public void setSibsp(int sibsp) {
        this.sibsp = sibsp;
    }

    public int getParch() {
        return parch;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return Cabin;
    }

    public void setCabin(String cabin) {
        Cabin = cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHome_dest() {
        return home_dest;
    }

    public void setHome_dest(String home_dest) {
        this.home_dest = home_dest;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pClass=" + pClass +
                ", survived=" + survived +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", sibsp=" + sibsp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", Cabin='" + Cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                ", boat='" + boat + '\'' +
                ", body='" + body + '\'' +
                ", home_dest='" + home_dest + '\'' +
                "}}}}}}}}}}}}";
    }
}
