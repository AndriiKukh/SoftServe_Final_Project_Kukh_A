package com.company;

import java.io.*;
import java.util.*;

class Menu {
    public static void mainMenu(ArrayList<Employee> list){
        Scanner s = new Scanner(System.in);
        int optionMenu = 0;
        while (optionMenu != 7) {
            Menu.printMenu();
            optionMenu = s.nextInt();
            if (optionMenu == 1) {
                addEmp(list);
            } else if (optionMenu == 2) {
                viewEmp(list);
            } else if (optionMenu == 3) {
                editEmp(list);
            } else if (optionMenu == 4) {
                removeEmp(list);
            } else if (optionMenu == 5) {
                genReport(list);
            } else if (optionMenu == 6) {
                readWrite(list);
            } else if (optionMenu == 7)
                System.out.println("Exit program...");
            else
                System.out.println("Error option: pick one option from 1 to 7");
        }
    }
    private static void printMenu() {
        System.out.println("\nChoose option from the list:");
        System.out.println("1. add new employee");
        System.out.println("2. view employee info");
        System.out.println("3. edit existing employee");
        System.out.println("4. delete existing employee");
        System.out.println("5. generate report");
        System.out.println("6. read or write to/from File");
        System.out.println("7. exit from program");
    }
    private static void addEmp(ArrayList<Employee> list) {
        System.out.println("Creating new employee...");
        String lastName = Validation.validLastName();
        String firstName = Validation.validFirstName();
        String middleName = Validation.validMiddleName();
        String dateOfBirth = Validation.validDateOfBirth();
        String position = Validation.validPosition();
        String department = Validation.validDepartment();
        int roomNumber = Validation.validRoomNumber();
        String workPhone = Validation.validWorkPhone();
        String email = Validation.validEmail();
        double salary = Validation.validSalary();
        String dateOfStartWork = Validation.validDateOfStartWork();
        String additionalInfo = Validation.validAddInfo();

        Employee newEmp = new Employee(lastName, firstName, middleName, dateOfBirth, position, department,
                roomNumber, workPhone, email, salary, dateOfStartWork, additionalInfo);
        list.add(newEmp);
        System.out.println("\nA new Employee has been added");
        System.out.println(newEmp.toString());
        writeFile(list);
    }
    private static void viewEmp(ArrayList<Employee> list) {
        Scanner s = new Scanner(System.in);
        System.out.println("Employee List");
        while (true) {
            if (list.isEmpty()) {
                System.out.println("List is Empty...");
                System.out.println("Fill the list from the File or add manually");
                break;
            } else {
                System.out.println("");
                for (int i = 0; i < list.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    list.get(i).printIDFLname();
                }
                System.out.println("Press 0 for Exit from this menu");
                System.out.println("Pick a number of employee you want to view:");
                int num;
                num = s.nextInt();
                if (num <= list.size() && num > 0) {
                    System.out.println(list.get(num - 1).toString());
                }
                else if (num == 0){
                    System.out.println("exiting from this menu");
                    break;
                }
                else
                    System.out.println("There is no employee at this number.");
            }
        }
    }
    private static void editEmp(ArrayList<Employee> list) {
        Scanner s = new Scanner(System.in);
        System.out.println("Editing existing employee...");
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).printIDFLname();
        }
        System.out.println("Pick a number of employee you want to edit:");
        int num;
        num = s.nextInt();
        if (num <= list.size() && num > 0) {
            int edit = 0;
            num--;
            while (edit != 13) {
                System.out.println("\nPick one option from 1 to 13 you want to edit: ");
                System.out.println("1.  lastName");
                System.out.println("2.  firstName");
                System.out.println("3.  middleName");
                System.out.println("4.  dateOfBirth");
                System.out.println("5.  position");
                System.out.println("6.  department");
                System.out.println("7.  roomNumber");
                System.out.println("8.  workPhone");
                System.out.println("9.  email");
                System.out.println("10. salary");
                System.out.println("11. dateOfStartWork");
                System.out.println("12. additionalInfo");
                System.out.println("13. Exit editing");
                edit = s.nextInt();
                s.nextLine();
                if (edit == 1) {
                    System.out.println("Existing lastName is: " + list.get(num).getFullName().getLastName());
                    System.out.println("Enter new lastName or change existing");
                    list.get(num).getFullName().setLastName(Validation.validLastName());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New lastName is: " + list.get(num).getFullName().getLastName());
                } else if (edit == 2) {
                    System.out.println("Existing firstName is: " + list.get(num).getFullName().getFirstName());
                    System.out.println("Enter new firstName or change existing");
                    list.get(num).getFullName().setFirstName(Validation.validFirstName());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New firstName is: " + list.get(num).getFullName().getFirstName());
                } else if (edit == 3) {
                    System.out.println("Existing middleName is: " + list.get(num).getFullName().getMiddleName());
                    System.out.println("Enter new middleName or change existing");
                    list.get(num).getFullName().setMiddleName(Validation.validMiddleName());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New middleName is: " + list.get(num).getFullName().getMiddleName());
                } else if (edit == 4) {
                    System.out.println("Existing dateOfBirth is: " + list.get(num).getWorkInfo().getDateOfBirth());
                    System.out.println("Enter new dateOfBirth or change existing");
                    list.get(num).getWorkInfo().setDateOfBirth(Validation.validDateOfBirth());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New dateOfBirth is: " + list.get(num).getWorkInfo().getDateOfBirth());
                } else if (edit == 5) {
                    System.out.println("Existing position is: " + list.get(num).getWorkInfo().getPosition());
                    System.out.println("Enter new position or change existing");
                    list.get(num).getWorkInfo().setPosition(Validation.validPosition());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New position is: " + list.get(num).getWorkInfo().getPosition());
                } else if (edit == 6) {
                    System.out.println("Existing department is: " + list.get(num).getWorkInfo().getDepartment());
                    System.out.println("Enter new department or change existing");
                    list.get(num).getWorkInfo().setDepartment(Validation.validDepartment());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New department is: " + list.get(num).getWorkInfo().getDepartment());
                } else if (edit == 7) {
                    System.out.println("Existing roomNumber is: " + list.get(num).getWorkInfo().getRoomNumber());
                    System.out.println("Enter new roomNumber or change existing");
                    list.get(num).getWorkInfo().setRoomNumber(Validation.validRoomNumber());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New roomNumber is: " + list.get(num).getWorkInfo().getRoomNumber());
                } else if (edit == 8) {
                    System.out.println("Existing workPhone is: " + list.get(num).getWorkInfo().getWorkPhone());
                    System.out.println("Enter new workPhone or change existing");
                    list.get(num).getWorkInfo().setWorkPhone(Validation.validWorkPhone());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New workPhone is: " + list.get(num).getWorkInfo().getWorkPhone());
                } else if (edit == 9) {
                    System.out.println("Existing email is: " + list.get(num).getWorkInfo().getEmail());
                    System.out.println("Enter new email or change existing");
                    list.get(num).getWorkInfo().setEmail(Validation.validEmail());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New email is: " + list.get(num).getWorkInfo().getEmail());
                } else if (edit == 10) {
                    System.out.println("Existing salary is: " + list.get(num).getWorkInfo().getSalary());
                    System.out.println("Enter new salary or change existing");
                    list.get(num).getWorkInfo().setSalary(Validation.validSalary());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New salary is: " + list.get(num).getWorkInfo().getSalary());
                } else if (edit == 11) {
                    System.out.println("Existing dateOfStartWork is: " + list.get(num).getWorkInfo().getDateOfStartWork());
                    System.out.println("Enter new dateOfStartWork or change existing");
                    list.get(num).getWorkInfo().setDateOfStartWork(Validation.validDateOfStartWork());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New dateOfStartWork is: " + list.get(num).getWorkInfo().getDateOfStartWork());
                } else if (edit == 12) {
                    System.out.println("Existing additionalInfo is: " + list.get(num).getAdditionalInfo());
                    System.out.println("Enter new additionalInfo or change existing");
                    list.get(num).setAdditionalInfo(Validation.validAddInfo());
                    System.out.println("Data has been updated successfully!");
                    System.out.println("New additionalInfo is: " + list.get(num).getAdditionalInfo());
                } else if (edit == 13) {
                    System.out.println("Exit editing...");
                } else
                    System.out.println("Error, pick one option from 1 to 13: ");
            }
        } else
            System.out.println("There is no employee at this number.");
    }
    private static void removeEmp(ArrayList<Employee> list) {
        System.out.println("Deleting existing employee...");
        Scanner s = new Scanner(System.in);
        System.out.println("Employee List");
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).printIDFLname();
        }
        System.out.println("Pick a number of employee you want to remove:");
        int num;
        num = s.nextInt();
        if (num <= list.size() && num > 0) {
            System.out.println("Are you sure you want to delete employee: " + list.get(num - 1).getFullName().getFirstName()
                    + " " + list.get(num - 1).getFullName().getLastName());
            int answer;
            System.out.println("1. Yes \n2. No");
            answer = s.nextInt();
            s.nextLine();
            if (answer == 1) {
                list.remove(num - 1);
                System.out.println("Deleting employee...");
                System.out.println("Employee has been deleted successfully");
                System.out.println("\nNew list of Employees has been updated");
                for (int i = 0; i < list.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    list.get(i).printIDFLname();
                }
            } else if (answer == 2) {
                System.out.println("Cancel deleting employee ");
            } else
                System.out.println("Error. Please pick option 1 or 2");
        } else
            System.out.println("There is no employee at this number.");
    }
    private static void genReport(ArrayList<Employee> list) {
        System.out.println("Generating report...");
        Scanner s = new Scanner(System.in);
        int option;
        System.out.println("Pick one option from the list to generate report: ");
        System.out.println("1. All Employees");
        System.out.println("2. Sort by Last Name");
        System.out.println("3. Sort by Position");
        System.out.println("4. Sort by Department");
        System.out.println("5. Sort by Salary");
        option = s.nextInt();
        s.nextLine();
        if (option == 1) {
            System.out.println("List of All Employees:");
            System.out.println("________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("| ID |   Last   |   First  | Middle Name |  Date of   |  Position  | Department |  Room  |    Work Phone     |        E-Mail        | Salary |   Date of  | Additional |");
            System.out.println("|    |   Name   |   Name   |             |   Birth    |            |            | Number |                   |                      |        | Start Work |   Info     |");
            System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            for (Employee aList : list) {
                System.out.printf("|%2d  | %-9.8s| %-9.8s| %-12.11s| %-11.10s| %-11.10s| %-11.10s| %-7.6s| %-18.17s| %-21.20s| %-7.6s| %-11.10s| %-11.10s|%n",
                        aList.getId(), aList.getFullName().getLastName(), aList.getFullName().getFirstName(), aList.getFullName().getMiddleName(),
                        aList.getWorkInfo().getDateOfBirth(), aList.getWorkInfo().getPosition(), aList.getWorkInfo().getDepartment(), aList.getWorkInfo().getRoomNumber(),
                        aList.getWorkInfo().getWorkPhone(), aList.getWorkInfo().getEmail(), aList.getWorkInfo().getSalary(), aList.getWorkInfo().getDateOfStartWork(), aList.getAdditionalInfo());
                System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            }
        } else if (option == 2) {
            System.out.println("Sorted list by Last Name (Ascending)");
            list.sort((o1, o2) -> {
                if (!o1.getFullName().getLastName().equals(o2.getFullName().getLastName()))
                    return o1.getFullName().getLastName().compareTo(o2.getFullName().getLastName());
                else
                    return o1.getFullName().getFirstName().compareTo(o2.getFullName().getFirstName());
            });
            System.out.println("________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("| ID |   Last   |   First  | Middle Name |  Date of   |  Position  | Department |  Room  |    Work Phone     |        E-Mail        | Salary |   Date of  | Additional |");
            System.out.println("|    |   Name   |   Name   |             |   Birth    |            |            | Number |                   |                      |        | Start Work |   Info     |");
            System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            for (Employee aList : list) {
                System.out.printf("|%2d  | %-9.8s| %-9.8s| %-12.11s| %-11.10s| %-11.10s| %-11.10s| %-7.6s| %-18.17s| %-21.20s| %-7.6s| %-11.10s| %-11.10s|%n",
                        aList.getId(), aList.getFullName().getLastName(), aList.getFullName().getFirstName(), aList.getFullName().getMiddleName(),
                        aList.getWorkInfo().getDateOfBirth(), aList.getWorkInfo().getPosition(), aList.getWorkInfo().getDepartment(), aList.getWorkInfo().getRoomNumber(),
                        aList.getWorkInfo().getWorkPhone(), aList.getWorkInfo().getEmail(), aList.getWorkInfo().getSalary(), aList.getWorkInfo().getDateOfStartWork(), aList.getAdditionalInfo());
                System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            }
        } else if (option == 3) {
            System.out.println("Sorted list by Position (searching)");
            System.out.println("What Positions would you like to see:");
            String pos = s.nextLine();
            pos = pos.substring(0,1).toUpperCase() + pos.substring(1);
            System.out.println("________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("| ID |   Last   |   First  | Middle Name |  Date of   |  Position  | Department |  Room  |    Work Phone     |        E-Mail        | Salary |   Date of  | Additional |");
            System.out.println("|    |   Name   |   Name   |             |   Birth    |            |            | Number |                   |                      |        | Start Work |   Info     |");
            System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            for (Employee aList : list) {
                if (pos.equals(aList.getWorkInfo().getPosition())) {
                    System.out.printf("|%2d  | %-9.8s| %-9.8s| %-12.11s| %-11.10s| %-11.10s| %-11.10s| %-7.6s| %-18.17s| %-21.20s| %-7.6s| %-11.10s| %-11.10s|%n",
                            aList.getId(), aList.getFullName().getLastName(), aList.getFullName().getFirstName(), aList.getFullName().getMiddleName(),
                            aList.getWorkInfo().getDateOfBirth(), aList.getWorkInfo().getPosition(), aList.getWorkInfo().getDepartment(), aList.getWorkInfo().getRoomNumber(),
                            aList.getWorkInfo().getWorkPhone(), aList.getWorkInfo().getEmail(), aList.getWorkInfo().getSalary(), aList.getWorkInfo().getDateOfStartWork(), aList.getAdditionalInfo());
                    System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                }
            }
        } else if (option == 4) {
            System.out.println("Sorted list by Department (searching)");
            System.out.println("What Department would you like to see:");
            String dep = s.nextLine();
            dep = dep.substring(0,1).toUpperCase() + dep.substring(1);
            System.out.println("________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("| ID |   Last   |   First  | Middle Name |  Date of   |  Position  | Department |  Room  |    Work Phone     |        E-Mail        | Salary |   Date of  | Additional |");
            System.out.println("|    |   Name   |   Name   |             |   Birth    |            |            | Number |                   |                      |        | Start Work |   Info     |");
            System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            for (Employee aList : list) {
                if (dep.equals(aList.getWorkInfo().getDepartment())) {
                    System.out.printf("|%2d  | %-9.8s| %-9.8s| %-12.11s| %-11.10s| %-11.10s| %-11.10s| %-7.6s| %-18.17s| %-21.20s| %-7.6s| %-11.10s| %-11.10s|%n",
                            aList.getId(), aList.getFullName().getLastName(), aList.getFullName().getFirstName(), aList.getFullName().getMiddleName(),
                            aList.getWorkInfo().getDateOfBirth(), aList.getWorkInfo().getPosition(), aList.getWorkInfo().getDepartment(), aList.getWorkInfo().getRoomNumber(),
                            aList.getWorkInfo().getWorkPhone(), aList.getWorkInfo().getEmail(), aList.getWorkInfo().getSalary(), aList.getWorkInfo().getDateOfStartWork(), aList.getAdditionalInfo());
                    System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                }
            }
        } else if (option == 5) {
            System.out.println("Sorted list by Salary (Ascending)");
            list.sort((o1, o2) -> {
                if (o1.getWorkInfo().getSalary() != o2.getWorkInfo().getSalary())
                    return Double.compare(o1.getWorkInfo().getSalary(), o2.getWorkInfo().getSalary());
                else
                    return o1.getFullName().getLastName().compareTo(o2.getFullName().getLastName());
            });
            System.out.println("________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("| ID |   Last   |   First  | Middle Name |  Date of   |  Position  | Department |  Room  |    Work Phone     |        E-Mail        | Salary |   Date of  | Additional |");
            System.out.println("|    |   Name   |   Name   |             |   Birth    |            |            | Number |                   |                      |        | Start Work |   Info     |");
            System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            for (Employee aList : list) {
                System.out.printf("|%2d  | %-9.8s| %-9.8s| %-12.11s| %-11.10s| %-11.10s| %-11.10s| %-7.6s| %-18.17s| %-21.20s| %-7.6s| %-11.10s| %-11.10s|%n",
                        aList.getId(), aList.getFullName().getLastName(), aList.getFullName().getFirstName(), aList.getFullName().getMiddleName(),
                        aList.getWorkInfo().getDateOfBirth(), aList.getWorkInfo().getPosition(), aList.getWorkInfo().getDepartment(), aList.getWorkInfo().getRoomNumber(),
                        aList.getWorkInfo().getWorkPhone(), aList.getWorkInfo().getEmail(), aList.getWorkInfo().getSalary(), aList.getWorkInfo().getDateOfStartWork(), aList.getAdditionalInfo());
                System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
            }
        } else
            System.out.println("Error: Pick one option from 1 to 5");
    }
    private static void writeFile(ArrayList<Employee> list){
        File file = new File("textFile.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Employee aList : list) {
                bufferedWriter.write(aList.getId() + "; ");
                bufferedWriter.write(aList.getFullName().getLastName() + "; ");
                bufferedWriter.write(aList.getFullName().getFirstName() + "; ");
                bufferedWriter.write(aList.getFullName().getMiddleName() + "; ");
                bufferedWriter.write(aList.getWorkInfo().getDateOfBirth() + "; ");
                bufferedWriter.write(aList.getWorkInfo().getPosition() + "; ");
                bufferedWriter.write(aList.getWorkInfo().getDepartment() + "; ");
                bufferedWriter.write(aList.getWorkInfo().getRoomNumber() + "; ");
                bufferedWriter.write(aList.getWorkInfo().getWorkPhone() + "; ");
                bufferedWriter.write(aList.getWorkInfo().getEmail() + "; ");
                bufferedWriter.write(aList.getWorkInfo().getSalary() + "; ");
                bufferedWriter.write(aList.getWorkInfo().getDateOfStartWork() + "; ");
                bufferedWriter.write(aList.getAdditionalInfo());
                bufferedWriter.newLine();
            }
            System.out.println("Writing data into the File...");
            System.out.println("Data has been successfully added into the File");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static void readFile(ArrayList<Employee> list) {
        System.out.println("\nReading from File...");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("textFile.txt"))) {
                String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempArray = line.split("; ");
                System.out.println("Creating new employee...");
                String lastName = tempArray[1];
                String firstName = tempArray[2];
                String middleName = tempArray[3];
                String dateOfBirth = tempArray[4];
                String position = tempArray[5];
                String department = tempArray[6];
                int roomNumber = Integer.parseInt(tempArray[7]);
                String workPhone = tempArray[8];
                String email = tempArray[9];
                double salary = Double.parseDouble(tempArray[10]);
                String dateOfStartWork = tempArray[11];
                String additionalInfo = tempArray[12];

                Employee newEmp = new Employee(lastName, firstName, middleName, dateOfBirth, position, department,
                                            roomNumber, workPhone, email, salary, dateOfStartWork, additionalInfo);
                list.add(newEmp);
                System.out.println(Arrays.toString(tempArray));
            }
        }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    private static void readWrite(ArrayList<Employee> list) {
        String option = "";
        Scanner scr = new Scanner(System.in);
        while (!option.equals("3")) {
            System.out.println("\nChoose option from the list:");
            System.out.println("1. Read from File");
            System.out.println("2. Write to File");
            System.out.println("3. Exit to Main Menu");
            option = scr.nextLine();
            switch (option) {
                case "1":
                    readFile(list);
                    break;
                case "2":
                    writeFile(list);
                    break;
                case "3":
                    System.out.println("exiting read/write menu...");
                    break;
                default:
                    System.out.println("Error. pick option from 1 to 3");
                    break;
            }
        }
    }
}