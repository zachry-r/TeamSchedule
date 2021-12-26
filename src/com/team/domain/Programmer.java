package com.team.domain;
import com.team.service.Status;

/**
 * 程序员
 *
 * @auther zkr
 * @date 2021/12/25 17:05
 * @description
 * @since
 */
public class Programmer extends Employee{
    private int memberId; // 开发团队ID
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }


    /**
     * Get detail team string.
     *
     * @return the string
     */
    public String getDetailTeam(){
        return memberId+"/"+getDetails() + "\t程序员\t" + status;
    }



    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }
}
