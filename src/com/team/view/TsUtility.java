package com.team.view;

import java.util.Locale;
import java.util.Scanner;

/**
 * The type Ts utility.
 *
 * @auther zkr
 * @date 2021 /12/25 16:59
 * @description 项目中提供了 TSUtoloity 类，可方便的实现键盘访问
 * @since
 */
public class TsUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Read menu selection char.
     * <ul>
     *     <li>if input "1-4" return char</li>
     * <ul/>
     *
     * @return the char
     */
    public static char readMenuSelection(){
        char c;
        for (; ;){
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4'){
                System.out.println("选择错误，请重新输入");
            }else break;
        }
        return c;
    }


    /**
     * Read return.
     * Prompt to wait，Unit the user presses enter
     * to return
     */
    public static void readReturn(){
        System.out.println("按回车继续.....");
        readKeyBoard(100,true);
    }

    /**
     * Read int int.
     * lentgh no more than 2,
     * return int
     *
     * @return the int
     */
    public static int readInt(){
        int n;
        for (; ; ){
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return n;
    }

    /**
     * Read confirm selection char.
     *
     * @return the char
     */
    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str = readKeyBoard(1,false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N'){
                break;
            }else {
                System.out.println("选择有误，请重新输入");
            }
        }
        return c;
    }

    public static String readKeyBoard(int i, boolean blanReturn){
        String line ="";

        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            if (line.length() == 0){
                if (blanReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > i){
                System.out.println("输入长度 (不大于"+i+") 错误，请重新数日后");
                continue;
            }
            break;
        }
        return line;
    }
}
