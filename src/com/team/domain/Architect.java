package com.team.domain;

import com.team.service.Status;

/**
 *  架构师
 * @auther zkr
 * @date 2021/12/25 17:02
 * @description  架构师
 * @since
 */
public class Architect extends Programmer{
    private int stock;
    private int bonus;

    public Architect(int id, String name, int age, double salary,  Equipment equipment,int bonus, int stock) {
        super(id, name, age, salary,equipment);
        this.bonus = bonus;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getDetailTeam(){
        return getMemberId()+"/"+getDetails() + "\t架构师\t" + getStatus() + "\t" + bonus + "\t" +stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" +
                getStatus() + "\t" + bonus + "\t" + stock + "\t" + getEquipment().getDescription();
    }
}
