package com.company;

public class WorkInfo {
    ///////////// VARIABLES /////////////////////
    private String dateOfBirth;
    private String position;
    private String department;
    private int roomNumber;
    private String workPhone;
    private String email;
    private double salary;
    private String dateOfStartWork;

    ///////////////////// MAIN CONSTRUCTOR //////////////////////////////////////////////
    public WorkInfo(String dateOfBirth, String position, String department, int roomNumber, String workPhone,
                                                    String email, double salary, String dateOfStartWork) {
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.department = department;
        this.roomNumber = roomNumber;
        this.workPhone = workPhone;
        this.email = email;
        this.salary = salary;
        this.dateOfStartWork = dateOfStartWork;
    }
    //////////////// GETTERS ////////////////////////
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getPosition() {
        return position;
    }
    public String getDepartment() {
        return department;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getWorkPhone() {
        return workPhone;
    }
    public String getEmail() {
        return email;
    }
    public double getSalary() {
        return salary;
    }
    public String getDateOfStartWork() {
        return dateOfStartWork;
    }

    ///////////////// SETTERS ///////////////////////////
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDateOfStartWork(String dateOfStartWork) {
        this.dateOfStartWork = dateOfStartWork;
    }
}
