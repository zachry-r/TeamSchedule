package com.team.junit;

import com.team.domain.Employee;
import com.team.domain.Programmer;
import com.team.service.NameListService;
import com.team.service.TeamException;
import com.team.service.TeamService;
import org.junit.jupiter.api.Test;

/**
 * @auther zkr
 * @date 2021/12/26 10:31
 * @description
 * @since
 */
public class TeamServiceTest {

    @Test
    public void testAddMember(){
        TeamService service = new TeamService();
        NameListService listService = new NameListService();
        try { // 测试： 成员已满，无法添加
            // 团队中至多只能有一名架构师
            Employee[] allEmployees = listService.getAllEmployees();
            for (int i=1;i<allEmployees.length;i++){
                service.addMember(allEmployees[i]);
            }
            Programmer[] team = service.getTeam();
            System.out.println(team[0].getMemberId()+"/"+team[0].toString());
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testAddMember1(){
        TeamService service = new TeamService();
        TeamService s2 = new TeamService();
        NameListService listService = new NameListService();
        try {// 测试：该员工已经是别队成员，无法添加
            Employee employee = listService.getEmployees(2);
            service.addMember(employee);
            s2.addMember(employee);
        }catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddMember2(){
        TeamService service = new TeamService();
        NameListService listService = new NameListService();
        try {// 测试：该员工已在开发团队，无法添加
            Employee employee = listService.getEmployees(2);
            service.addMember(employee);
            service.addMember(employee);
        }catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddMember3(){
        TeamService service = new TeamService();
        NameListService listService = new NameListService();
        try {// 测试：该成员不是开发人员无法添加，无法添加
            Employee employee = listService.getEmployees(1);
            service.addMember(employee);
        }catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddMember4(){
        TeamService service = new TeamService();
        NameListService listService = new NameListService();
        try {// 测试：团队中至多只能有两名设计师，无法添加
            Employee employee = listService.getEmployees(5);
            Employee e2 = listService.getEmployees(7);
            Employee e3 = listService.getEmployees(12);
            service.addMember(employee);
            service.addMember(e2);
            // 第三个设计师
//            service.addMember(e3);

            Programmer[] team = service.getTeam();
            for (int i=0;i<team.length;i++){
                System.out.println(team[i].getMemberId()+"/"+team[i].toString());
            }
        }catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddMember5(){
        TeamService service = new TeamService();
        NameListService listService = new NameListService();
        try {// 测试：团队中至多只能有三名程序员，无法添加
            Employee employee = listService.getEmployees(3);
            Employee e2 = listService.getEmployees(4);
            Employee e3 = listService.getEmployees(6);
            Employee e4 = listService.getEmployees(10);
            service.addMember(employee);
            service.addMember(e2);
            service.addMember(e3);

//            service.addMember(e4);

            Programmer[] team = service.getTeam();
            for (int i=0;i<team.length;i++){
                System.out.println(team[i].getMemberId()+"/"+team[i].toString());
            }
        }catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddMember6(){
        TeamService service = new TeamService();
        NameListService listService = new NameListService();
        try {// 测试：删除，员工不存在删除失败
            Employee employee = listService.getEmployees(3);
            Employee e2 = listService.getEmployees(4);
            Employee e3 = listService.getEmployees(6);
            Employee e4 = listService.getEmployees(10);
            service.addMember(employee);
            service.addMember(e2);
            service.addMember(e3);


            Programmer[] team = service.getTeam();
            for (int i=0;i<team.length;i++){
                System.out.println(team[i].getMemberId()+"/"+team[i].toString());
            }

            // 删除
            service.removeMember(1);



            for (int i=0;i<team.length;i++){
                System.out.println(team[i].getMemberId()+"/"+team[i].toString());
            }

        }catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
