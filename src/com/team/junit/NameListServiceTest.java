package com.team.junit;

import com.team.domain.Employee;
import com.team.service.NameListService;
import com.team.service.TeamException;
import org.junit.jupiter.api.Test;

/**
 * @auther zkr
 * @date 2021/12/25 17:05
 * @description
 * @since
 */
public class NameListServiceTest {

    @Test
    public void testNameListService(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i=0;i<employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 1;
        id = 100;
        try{
            Employee employee = service.getEmployees(id);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }
}
