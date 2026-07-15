package com.codeveda.level2.employee;

import java.util.ArrayList;

public class EmployeeService {

    private ArrayList<Employee> employees= new ArrayList<>();


    public void addEmployee(Employee emp){
        Employee empId=findEmployeeById(emp.getID());

        if(empId !=null ){
            System.out.println("Employee id "+emp.getID()+ "already exist");
            return;
        }
        employees.add(emp);
        System.out.println("Employee added successfully..");
    }

    public void viewEmployees(){
        System.out.println(employees);
        System.out.println("Here is all employee..");
    }

    public  void updateEmployee(int id, String name, double salary, String department ){

        Employee emp=findEmployeeById(id);
if(emp != null){
    emp.setName(name);
    emp.setSalary(salary);
    emp.setDepartment(department);

    System.out.println("Employee update successfully...");
}else{
    System.out.println("no employee is found");
}
    }

public void  deleteEmployee(int id){

        Employee emp=findEmployeeById(id);

        if(emp != null){
            employees.remove(emp);
            System.out.println("Employee deleted sucessfully");
        }else {
            System.out.println("Employee is not found.");
        }
}

public Employee findEmployeeById(int id) {
    for (Employee emp : employees) {
        if(emp.getID() == id){
            return emp;
        }

    }
    return null;

}
}
