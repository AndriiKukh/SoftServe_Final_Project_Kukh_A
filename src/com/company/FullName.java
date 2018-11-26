package com.company;

public class FullName {
    ///////////// VARIABLES /////////////////////
    private String lastName;
    private String firstName;
    private String middleName;

    ///////////////////// MAIN CONSTRUCTOR //////////////////
    public FullName(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    //////////////// GETTERS ////////////////////////
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }

    ///////////////// SETTERS ///////////////////////////
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }




}
