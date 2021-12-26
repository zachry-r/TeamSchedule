package com.team.service;

import com.team.domain.Architect;
import com.team.domain.Designer;
import com.team.domain.Employee;
import com.team.domain.Programmer;

/**
 * The type Team service.
 *
 * @auther zkr
 * @date 2021 /12/25 17:06
 * @description
 * @since
 */
public class TeamService {
    private  int counter = 1;  // 生成唯一ID
    private  final int MAX_MEMBER = 5;
    private  Programmer[] team = new Programmer[MAX_MEMBER];
    private  int total = 0;

    public int getTotal() {
        return total;
    }

    /**
     * Get team programmer [ ].
     *
     * @return the programmer [ ]
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i=0;i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * Add member.
     * <ul>
     * <li>成员已满，无法添加</li>
     * <li>该成员不是开发人员，无法添加</li>
     * <li>该员工已在开发团队，无法添加</li>
     * <li>该员工已经是别队成员，无法添加</li>
     * <li>该员工正在休假，无法添加</li>
     * <li>团队中至多只能有一名架构师，无法添加</li>
     * <li>团队中至多只能有两名设计师,无法添加</li>
     * <li>团队中至多只能有三名程序员,无法添加</li>
     * </ul>
     *
     * @param e the e
     * @throws TeamException the team exception
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }

        if (!(e instanceof Programmer)){
            throw  new TeamException("该成员不是开发人员无法添加");
        }

        if (isExist(e)){
            throw new TeamException("该员工已在开发团队，无法添加");
        }

        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工已经是别队成员，无法添加");
        }else if ("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工正在休假，无法添加");
        }

        // 获取team中已有成员中架构师，设计师，程序员的人数
        int numOfArch =0,numofDef = 0,numOfPro = 0;

        for (int i=0;i<total;i++){
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numofDef++;
            }else if (team[i] instanceof Programmer){
                numOfPro++;
            }
        }
        if (p instanceof Architect){
            if (numOfArch >=1){
                throw new TeamException("团队中至多一名架构师");
            }
        }else if (p instanceof Designer){
            if (numofDef >=2){
                throw new TeamException("团队中至多两名设计师");
            }
        }else if (p instanceof Programmer) {
            if (numofDef >= 3) {
                throw new TeamException("团队中至多三名程序员");
            }
        }


//        team[total].setMemberId(counter);
        p.setMemberId(counter++);
        team[total++] = p;
        p.setStatus(Status.BUSY);


    }


    /**
     * 员工是否已经在开发团队判断
     *
     * @param e Employee
     * @return Boolean
     */
    private Boolean isExist(Employee e) {
        for (int i=0;i<total;i++){
            return team[i].getId() == e.getId();
        }
        return false;
    }



    /**
     * Remove member.
     *
     * @param memberId the member id
     */
    public void removeMember(int memberId) throws TeamException{
        int i=0;
        for (;i<total;i++){
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        // 找不到指定的，抛异常
        if (i == total){
            throw new TeamException("找不到指定的员工");
        }

        // 删除操作
        for (int j=i+1;j<total;j++){
            team[j-1] = team[j];
        }
        team[--total] = null;



    }


}
