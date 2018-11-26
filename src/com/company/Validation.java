package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static String validLastName(){
        Scanner s = new Scanner(System.in);
        String lastName;
        while (true) {
            System.out.println("Enter Last Name of Employee: ");
            lastName = s.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][\\-a-zA-Z]{1,20}$");
            Matcher m = p.matcher(lastName);
            if (m.matches()) {
                System.out.println("Successful validation");
                lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. No digits and symbols allowed, except \"-\" sign");
                System.out.println("2. No more then 20 characters allowed");
                System.out.println("3. Minimum 2 characters allowed");
            }
        }
        return lastName;
    }
    public static String validFirstName(){
        Scanner s = new Scanner(System.in);
        String firstName;
        while (true) {
            System.out.println("Enter First Name of Employee: ");
            firstName = s.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z]{1,20}$");
            Matcher m = p.matcher(firstName);
            if (m.matches()) {
                System.out.println("Successful validation");
                firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. No digits and symbols allowed");
                System.out.println("2. No more then 20 characters allowed");
                System.out.println("3. Minimum 2 characters allowed");
            }
        }
        return firstName;
    }
    public static String validMiddleName(){
        Scanner s = new Scanner(System.in);
        String middleName;
        while (true) {
            System.out.println("Enter Middle Name of Employee: ");
            middleName = s.nextLine();
            Pattern p = Pattern.compile("^[ a-zA-Z][ a-z]{0,20}$");
            Matcher m = p.matcher(middleName);
            if (m.matches()) {
                System.out.println("Successful validation");
                if (!middleName.equals(" ") && middleName.length() > 0)
                    middleName = middleName.substring(0,1).toUpperCase() + middleName.substring(1);
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. SpaceBar allowed. (means no middle name)");
                System.out.println("2. No digits and symbols allowed");
                System.out.println("3. No more then 20 characters allowed");
            }
        }
        return middleName;
    }
    public static String validDateOfBirth(){
        Scanner s = new Scanner(System.in);
        String dateOfBirth;
        while (true) {
            System.out.println("Enter Date of Birth of Employee (format: dd/mm/yyyy): ");
            dateOfBirth = s.nextLine();
            Pattern p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
            Matcher m = p.matcher(dateOfBirth);
            if (m.matches()) {
                System.out.println("Successful validation");
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. dd - maximum value is 31");
                System.out.println("2. mm - maximum value is 12");
                System.out.println("3. yyyy - minimum value is 19..");
                System.out.println("4. yyyy - maximum value is 20..");
                System.out.println("5. split symbols allowed: -/.");
            }
        }
        return dateOfBirth;
    }
    public static String validPosition(){
        Scanner s = new Scanner(System.in);
        String position;
        while (true) {
            System.out.println("Enter Position of Employee: ");
            position = s.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][ a-zA-Z0-9]{1,20}$");
            Matcher m = p.matcher(position);
            if (m.matches()) {
                System.out.println("Successful validation");
                position = position.substring(0,1).toUpperCase() + position.substring(1);
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. No more then 20 characters allowed");
                System.out.println("2. Minimum 2 characters allowed");
            }
        }
        return position;
    }
    public static String validDepartment(){
        Scanner s = new Scanner(System.in);
        String department;
        while (true) {
            System.out.println("Enter Department of Employee: ");
            department = s.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][ A-Za-z]{1,20}$");
            Matcher m = p.matcher(department);
            if (m.matches()) {
                System.out.println("Successful validation");
                department = department.substring(0,1).toUpperCase() + department.substring(1);
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. No digits and symbols allowed");
                System.out.println("2. No more then 20 characters allowed");
                System.out.println("3. Minimum 2 characters allowed");
            }
        }
        return department;
    }
    public static int validRoomNumber(){
        Scanner s = new Scanner(System.in);
        String roomNumber;
        int rNumber;
        while (true) {
            System.out.println("Enter Room Number of Employee: ");
            roomNumber = s.nextLine();
            Pattern p = Pattern.compile("^[0-9]{1,8}$");
            Matcher m = p.matcher(roomNumber);
            if (m.matches()) {
                System.out.println("Successful validation");
                rNumber = Integer.parseInt(roomNumber);
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. Only digits allowed here");
                System.out.println("2. Minimum 1 digit requires");
                System.out.println("3. Maximum 8 digits");
            }
        }
        return rNumber;
    }
    public static String validWorkPhone(){
        Scanner s = new Scanner(System.in);
        String workPhone;
        while (true) {
            System.out.println("Enter Work Phone Employee (format +380(99)-488-60-40)): ");
            workPhone = s.nextLine();
            Pattern p = Pattern.compile("^[+][380][()0-9\\-]{11,20}$");
            Matcher m = p.matcher(workPhone);
            if (m.matches()) {
                System.out.println("Successful validation");
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. Phone number must starts from +380...");
                System.out.println("2. Only digits and ()- symbols allowed");
                System.out.println("3. Minimum 13 characters requires");
                System.out.println("4. Maximum 20 characters allowed");
            }
        }
        return workPhone;
    }
    public static String validEmail(){
        Scanner s = new Scanner(System.in);
        String email;
        while (true) {
            System.out.println("Enter E-mail of Employee (format: example01@exmail.com) ");
            email = s.nextLine();
            Pattern p = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
            Matcher m = p.matcher(email);
            if (m.matches()) {
                System.out.println("Successful validation");
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. email must contain @ and . signs");
                System.out.println("2. minimum 8 characters require");
                System.out.println("3. symbols @. must save sequence");
            }
        }
        return email;
    }
    public static Double validSalary(){
        Scanner s = new Scanner(System.in);
        String sl;
        Double salary;
        while (true) {
            System.out.println("Enter Salary of Employee: ");
            sl = s.nextLine();
            Pattern p = Pattern.compile("-?\\d+(\\.\\d{0,})?");
            Matcher m = p.matcher(sl);
            if (m.matches()) {
                System.out.println("Successful validation");
                salary = Double.parseDouble(sl);
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. Use only whole numbers or floating point numbers");
                System.out.println("1. Use . sign for floating numbers");
                System.out.println("2. Only digits allowed");
            }
        }
        return salary;
    }
    public static String validDateOfStartWork(){
        Scanner s = new Scanner(System.in);
        String dateOfStartWork;
        while (true) {
            System.out.println("Enter Date of Start Work Employee (format: dd/mm/yyyy): ");
            dateOfStartWork = s.nextLine();
            Pattern p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
            Matcher m = p.matcher(dateOfStartWork);
            if (m.matches()) {
                System.out.println("Successful validation");
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. dd - maximum value is 31");
                System.out.println("2. mm - maximum value is 12");
                System.out.println("3. yyyy - minimum value is 19..");
                System.out.println("4. yyyy - maximum value is 20..");
                System.out.println("5. split symbols allowed: -/.");
            }
        }
        return dateOfStartWork;
    }
    public static String validAddInfo(){
        Scanner s = new Scanner(System.in);
        String addinfo;
        while (true) {
            System.out.println("Enter any Additional Info about Employee: ");
            addinfo = s.nextLine();
            System.out.println(addinfo);
            Pattern p = Pattern.compile("^[a-z0-9A-B \\-\"@#$%+]{0,20}$");
            Matcher m = p.matcher(addinfo);
            if (m.matches()) {
                System.out.println("Successful validation");
                if(!addinfo.isEmpty())
                    addinfo = addinfo.substring(0,1).toUpperCase() + addinfo.substring(1);
                else
                    addinfo = " ";
                break;
            }
            else {
                System.out.println("Failed Validation");
                System.out.println("1. Maximum 20 characters allowed");
            }
        }
        return addinfo;
    }




}
