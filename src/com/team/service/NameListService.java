package com.team.service;

import com.team.domain.*;
import org.junit.jupiter.api.Test;

import static com.team.service.Data.*;


/**
 * The type Name list service.
 * @auther zkr
 * @date 2021 /12/25 17:05
 * @description
 * @since
 */
public class NameListService{
    private Employee[] employees;


    /**
     * Instantiates a new Name list service<br>
     * Init Employee
     *
     */
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < EMPLOYEES.length; i++) {
            // 获取员工的基本类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            // 获取Employee的 4个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            // 创建 Equipment equiment
            Equipment equiment = null;

            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age,salary );
                    break;
                case PROGRAMMER:
                    equiment = creatEquiment(i);
                    employees[i] = new Programmer(id, name, age, salary, equiment);
                    break;
                case DESIGNER:
                    equiment = creatEquiment(i);
                    employees[i] = new Designer(id, name, age, salary, equiment, Integer.parseInt(EMPLOYEES[i][5]));
                    break;
                case ARCHITECT:
                    equiment = creatEquiment(i);
                    employees[i] = new Architect(id, name, age, salary, equiment, Integer.parseInt(EMPLOYEES[i][5]),Integer.parseInt(EMPLOYEES[i][6]));
                    break;
            }
        }

    }


    /**
     * Get all employees employee [ ].<br>
     * Travese output all Employees
     *
     *
     * @return the employee [ ]
     */
    public Employee[] getAllEmployees() {
        return employees;

    }

    /**
     * Get employees employee.
     *
     * @param id the id
     * @return the employee
     * @throws TeamException the team exception
     */
    public Employee getEmployees(int id) throws TeamException{
        for (int i=0;i<employees.length;i++){
            if (employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new  TeamException("找不到指定员工");
    }


    /**
     * Creat equiment equipment.
     *
     * @param index the index
     * @return the equipment
     */
    public Equipment creatEquiment(int index){
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        Equipment equipment = null;
        switch (type){
            case PC:
                equipment = new PC(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
                break;
            case NOTEBOOK:
                equipment = new NoteBook(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
                break;
            case PRINTER:
                equipment = new Printer(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
                break;
        }
        return equipment;
    }




}
