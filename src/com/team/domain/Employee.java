package com.team.domain;

/**
 * 员工
 *
 * @auther zkr
 * @date 2021 /12/25 17:03
 * @description
 * @since
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
//    private String position; // 职位
//    private String status;
//    private double bonus; // 奖金
//    private int stock; // 股票
//    private String RequisitionEquipment; // 领用设备

    /**
     * Instantiates a new Employee.
     */
    public Employee() {
    }


    /**
     * Instantiates a new Employee.
     * General Employee
     *
     * @param id     the id
     * @param name   the name
     * @param age    the age
     * @param salary the salary
     */
    public Employee(int id, String name, int age, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDetails(){
        return id + "\t" + name + "\t" + age + "\t" +salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
