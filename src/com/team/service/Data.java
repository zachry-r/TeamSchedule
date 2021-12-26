package com.team.service;

public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    /**
     * <dl>
     * <dt>Employee:   10,id, name, salary</dt>
     * <dt>Programmer: 11,id, name, salary</dt>
     * <dt>Designer:   13,id, name, salary, bonus</dt>
     * <dt>Architect:  14,id, name, salary, bonus, stock</dt>
     * </dl>
     */
    public static final String[][] EMPLOYEES = {
            {"10","1","马云","22","3000"},
            {"13","2","马化腾","32","18000","15000","2000"},
            {"11","3","李彦宏","23","7000"},
            {"11","4","刘强东","24","7300"},
            {"12","5","雷军","28","10000","5000"},
            {"11","6","任志强","22","6800"},
            {"12","7","zss","32","18000","15000"},
            {"13","8","sds","32","18000","15000","2000"},
            {"12","9","fsfs","32","18000","15000"},
            {"11","10","asd","32","18000"},
            {"11","11","fdfga","32","18000"},
            {"11","12","sff","32","18000"},
    };

    /**
     * <dl>
     * <dt>PC       :21, model, display</dt>
     * <dt>NoteBook :22, model, price</dt>
     * <dt>Printer  :23, model, type</dt>
     * </dl>
     *
     */
    public static final String[][] EQUIPMENTS = {
            {},
            {"22","联想T4","6000"},
            {"21","戴尔","NEC17寸"},
            {"21","戴尔","三星17寸"},
            {"23","佳能2900","激光"},
            {"21","华硕","三星17寸"},
            {"21","华硕","三星17寸"},
            {"23","爱普生20k","针式"},
            {"22","惠普m6","5800"},
            {"21","戴尔","NEC17寸"},
            {"21","华硕","三星17寸"},
            {"22","惠普m6","5800"},
    };
}
