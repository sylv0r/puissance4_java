package com.codingf.input;

public class Input {
    // static methodes

    public static boolean verrifInput(int result){
        if (result<1 || result>7){
            return false;
        }else {
            return true;

        }
    }
}