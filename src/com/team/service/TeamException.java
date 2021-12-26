package com.team.service;

/**
 * @auther zkr
 * @date 2021/12/25 17:06
 * @description
 * @since
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -7034897190324745939L;

    public TeamException() {
        super();
    }

    public TeamException(String mes){
        super(mes);
    }
}
