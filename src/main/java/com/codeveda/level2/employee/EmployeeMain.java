package com.codeveda.level2.employee;

import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        EmployeeService  empService=new EmployeeService();

        while(true){
            System.out.println("***Employee Management System***");

             System.out.println("1. Add Employee");
            System.out.println("2. View All Employee");

            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice=sc.nextInt();


            switch (choice){
                case 1:
                    System.out.println("Enter employee id: ");
                    int id=sc.nextInt();

                    sc.nextLine();


                    if (empService.findEmployeeById(id) != null) {
                        System.out.println("Employee ID " + id + " already exists!");
                        break;

                    }


                    System.out.println("Enter employee name: ");
                    String name=sc.nextLine();

                    System.out.println("Enter employee salary: ");
                    double salary=sc.nextDouble();
                    sc.nextLine();


                    System.out.println("Enter employee department: ");
                    String dept=sc.nextLine();

                    Employee  emp=new Employee(id, name, salary, dept);

                    empService.addEmployee(emp);
break;

                case 2:
                    empService.viewEmployees();
                    break;

                case 3:
                    System.out.println("Enter employee id: ");
                    int updateId=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter employee Name: ");
                    String updateName=sc.nextLine();

                    System.out.println("Enter employee salary: ");
                    double updateSalary=sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Enter employee  department: ");
                    String updateDept=sc.nextLine();
                     Employee updateEmp=new Employee(updateId,updateName,updateSalary,updateDept);

                     empService.updateEmployee(updateId,updateName,updateSalary,updateDept);
                     break;

                case 4:
                    System.out.println("Enter Id to delete employee");
                    int deleteId=sc.nextInt();
                    empService.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("The program had=s been finished.");

                System.exit(0);

                default:
                    System.out.println("Invalid choice!! Try again between 1 and 5");

            }
        }
    }
}
