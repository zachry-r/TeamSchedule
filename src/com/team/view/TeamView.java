package com.team.view;

import com.team.domain.Employee;
import com.team.domain.Programmer;
import com.team.service.NameListService;
import com.team.service.TeamException;
import com.team.service.TeamService;

/**
 * The type Team view.
 *
 * @auther zkr
 * @date 2021 /12/25 16:59
 * @description
 * @since
 */
public class TeamView {
    /**
     * The List svc.
     */
    private NameListService listSvc = new NameListService();
    /**
     * The Team svc.
     */
    private TeamService teamSvc = new TeamService();

    /**
     * Enter main menu.
     */
    public void enterMainMenu(){


        boolean Flag = true;
        char mu = 0;
        while (Flag){
            if (mu != '1'){
                listAllEmployees();
            }

            System.out.println("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择（1-4）：");
            mu = TsUtility.readMenuSelection();

            switch (mu){
                case '1':
                    System.out.println("-------------------------团队成员列表------------------------------");
                    System.out.println();
                    System.out.println("TID/ID\t姓名\t年龄\t工作\t职位\t奖金\t股票");
                    getTeam();

                    break;
                case '2':
                    System.out.println("-------------------------添加成员------------------------------");
                    System.out.println("输入要添加的ID");
                    int id = TsUtility.readInt();
                    addMember(id);
                    TsUtility.readReturn();
                    break;
                case '3':
                    System.out.println("-------------------------删除成员------------------------------");
                    System.out.println("输入要删除的ID");
                    int MemId = TsUtility.readInt();
                    System.out.println("是否要删除(Y:N)");
                    char c = TsUtility.readConfirmSelection();
                    if (c == 'Y') {
                        deleteMember(MemId);
                    }
                    break;
                case '4':
                    System.out.println("是否要退出(Y:N)");
                    char c1 = TsUtility.readConfirmSelection();
                    if (c1 == 'Y'){
                        Flag = false;
                        break;
                    }

            }
        }

    }

    /**
     * List all employees.
     */
    private void listAllEmployees(){
        System.out.println("-------------------------开发团队调度软件------------------------------");
        Employee[] allEmployees = listSvc.getAllEmployees();
        for (int i =0;i<allEmployees.length;i++){
            System.out.println(allEmployees[i]);
        }
        System.out.println("--------------------------------------------------------------------");
    }

    /**
     * Get team.
     */
    private void getTeam(){
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length ==0){
            System.out.println("团队还没有人员");
        }

        for (int i=0;i< team.length;i++){
            System.out.println(team[i].getDetailTeam());
        }
    }

    /**
     * Add member.
     */
    private void addMember(int id){
        try {
            System.out.println(id);
            Employee employees = listSvc.getEmployees(id);

            teamSvc.addMember(employees);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Delete member.
     */
    private void deleteMember(int memId){
        try {
            teamSvc.removeMember(memId);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TeamView teamView = new TeamView();

        teamView.enterMainMenu();
    }

}
