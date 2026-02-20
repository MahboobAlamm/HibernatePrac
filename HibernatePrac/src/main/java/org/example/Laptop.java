package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "Desktop")
public class Laptop {

    @Id
    private int lId;
    @Column (name = "Laptop_Name")
    private String lName;
    private String lmodel;
    @Transient
    private String lYear;

    @ManyToOne
    private Student students;

    public Laptop() {
    }

    public Laptop(int lId, String lName, String lmodel) {
        this.lId = lId;
        this.lName = lName;
        this.lmodel = lmodel;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public String getlYear() {
        return lYear;
    }

    public void setlYear(String lYear) {
        this.lYear = lYear;
    }

    public String getLmodel() {
        return lmodel;
    }

    public void setLmodel(String lmodel) {
        this.lmodel = lmodel;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lId=" + lId +
                ", lName='" + lName + '\'' +
                ", lmodel='" + lmodel + '\'' +
                '}';
    }
}
