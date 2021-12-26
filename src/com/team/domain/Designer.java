package com.team.domain;

import com.team.service.Status;

/**
 * 设计师
 * @auther zkr
 * @date 2021/12/25 17:02
 * @description
 * @since
 */
public class Designer extends Programmer {
    private int bonus;

    public Designer(){}

    public Designer(int id, String name, int age, double salary, Equipment equipment, int bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getDetailTeam(){
        return getMemberId()+"/"+getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" +
                getStatus() + "\t" + bonus + "\t\t\t\t" + getEquipment().getDescription();
    }

}