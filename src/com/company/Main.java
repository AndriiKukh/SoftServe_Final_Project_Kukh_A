package com.company;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        System.out.println("\n|-------------------------------------------------------------------------------|");
        System.out.println("|\t This program oriented for crating and manipulating data of employees.      |" +
                "\n| Program could read and write data to/from file and generate different types   |" +
                "\n| of reports according to a certain type of sorting.                            |");
        System.out.println("|-------------------------------------------------------------------------------|");

        ArrayList<Employee> list = new ArrayList<>();

        Menu.mainMenu(list);

    }
}
