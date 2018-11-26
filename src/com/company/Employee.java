package com.company;

import java.util.Objects;

public class Employee {
    ///////////// VARIABLES /////////////////////
    private int id;
    private FullName fullName;
    private WorkInfo workInfo;
    private String additionalInfo;
    private static int count = 1;

    //////////////// GETTERS ////////////////////////
    public int getId() {
        return id;
    }
    public FullName getFullName() {
        return fullName;
    }
    public WorkInfo getWorkInfo() {
        return workInfo;
    }
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    ///////////////// SETTERS ///////////////////////////
    public void setId(int id) {
        this.id = id;
    }
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /////////////////////PRINTING ID,FIRST AND LAST NAME ////////////////////////////////
    public void printIDFLname(){
        System.out.println("ID: " + id + "   First name: " + fullName.getFirstName() + "   Last name: " + fullName.getLastName());
    }

    ///////////////////// MAIN CONSTRUCTOR //////////////////////////////////////////////
    public Employee(String lastName, String firstName, String middleName, String dateOfBirth, String position, String department, int roomNumber,
                    String workPhone, String email, double salary, String dateOfStartWork,
                    String additionalInfo){
        this.id = Employee.count++;
        this.fullName = new FullName(lastName, firstName, middleName);
        this.workInfo = new WorkInfo(dateOfBirth, position, department,
                roomNumber, workPhone, email, salary, dateOfStartWork);
        this.additionalInfo = additionalInfo;
    }
    @Override /////////////// OVERRIDING toSTRING ///////////////////////////////
    public String toString() {
        return "Employee Info:" +
                "\nid:              " + id +
                "\nlastName:        " + fullName.getLastName() +
                "\nfirstName:       " + fullName.getFirstName() +
                "\nmiddleName:      " + fullName.getMiddleName() +
                "\ndateOfBirth:     " + workInfo.getDateOfBirth() +
                "\nposition:        " + workInfo.getPosition() +
                "\ndepartment:      " + workInfo.getDepartment() +
                "\nroomNumber:      " + workInfo.getRoomNumber() +
                "\nworkPhone:       " + workInfo.getWorkPhone() +
                "\nemail:           " + workInfo.getEmail() +
                "\nsalary:          " + workInfo.getSalary() +
                "\ndateOfStartWork: " + workInfo.getDateOfStartWork() +
                "\nadditionalInfo:  " + additionalInfo;
    }
    @Override /////////////// OVERRIDING EQUALS /////////////////////////////////
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                workInfo.getRoomNumber() == employee.workInfo.getRoomNumber() &&
                Double.compare(employee.workInfo.getSalary(), workInfo.getSalary()) == 0 &&
                Objects.equals(fullName.getLastName(), employee.fullName.getLastName()) &&
                Objects.equals(fullName.getFirstName(), employee.fullName.getFirstName()) &&
                Objects.equals(fullName.getMiddleName(), employee.fullName.getMiddleName()) &&
                Objects.equals(workInfo.getDateOfBirth(), employee.workInfo.getDateOfBirth()) &&
                Objects.equals(workInfo.getPosition(), employee.workInfo.getPosition()) &&
                Objects.equals(workInfo.getDepartment(), employee.workInfo.getDepartment()) &&
                Objects.equals(workInfo.getWorkPhone(), employee.workInfo.getWorkPhone()) &&
                Objects.equals(workInfo.getEmail(), employee.workInfo.getEmail()) &&
                Objects.equals(workInfo.getDateOfStartWork(), employee.workInfo.getDateOfStartWork()) &&
                Objects.equals(additionalInfo, employee.additionalInfo);
    }
}
