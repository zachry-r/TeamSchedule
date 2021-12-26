package com.team.service;

/**
 * @auther zkr
 * @date 2021/12/25 17:06
 * @description
 * @since
 */
public class Status {
    private final String NAME;

    private Status(String name){
        this.NAME = name;
    }
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
