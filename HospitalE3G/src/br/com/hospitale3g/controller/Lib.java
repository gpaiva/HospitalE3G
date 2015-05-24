package br.com.hospitale3g.controller;

public class Lib {
    public static int iif(boolean condition, int resultTrue, int resultFalse){
        return(condition?resultTrue:resultFalse);
    }
    
    public static String iif(boolean condition, String resultTrue, String resultFalse){
        if(condition)
            return(resultTrue);
        return(resultFalse);
    }
    
    public static char iif(boolean condition, char resultTrue, char resultFalse){
        if(condition)
            return(resultTrue);
        return(resultFalse);
    }

    public static String quotedStr(char ch) {
        return ("'" + ch + "'");
    }

    public static String quotedStr(String str) {
        return ("'" + str + "'");
    }
}
