package com.example.recler_virw;

public class Student {
    private  int id ;
    private  double GPA ;
    private  String  name ;
    private  String filed ;

    public Student(int id, double GPA, String name, String filed) {
        this.id = id;
        this.GPA = GPA;
        this.name = name;
        this.filed = filed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }
}
