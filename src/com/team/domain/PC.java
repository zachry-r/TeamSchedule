package com.team.domain;

/**
 * @auther zkr
 * @date 2021/12/25 17:04
 * @description
 * @since
 */
public class PC implements Equipment {
    private String model;
    private String display;

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
        return display +"(" + model + ")";
    }

}
