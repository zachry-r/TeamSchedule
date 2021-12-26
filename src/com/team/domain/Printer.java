package com.team.domain;

/**
 * The type Printer.
 *
 * @auther zkr
 * @date 2021 /12/25 17:04
 * @description
 * @since
 */
public class Printer implements Equipment{
    private String name;
    private String type;

    /**
     * Instantiates a new Printer.
     *
     * @param name the name
     * @param type the type
     */
    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public String getDescription() {
        return name +"(" + type + ")";
    }

}
