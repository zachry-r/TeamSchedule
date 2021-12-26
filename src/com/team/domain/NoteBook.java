package com.team.domain;

/**
 * @auther zkr
 * @date 2021/12/25 17:04
 * @description
 * @since
 */
public class NoteBook implements Equipment{
    private String name;
    private String type;

    public NoteBook(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name +"(" + type + ")";
    }

}
