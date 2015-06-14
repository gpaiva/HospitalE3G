package br.com.hospitale3g.controller;

import javax.swing.JOptionPane;

public class Lib {

    public static int iif(boolean condition, int resultTrue, int resultFalse) {
        return (condition ? resultTrue : resultFalse);
    }

    public static String iif(boolean condition, String resultTrue, String resultFalse) {
        if (condition) {
            return (resultTrue);
        }
        return (resultFalse);
    }

    public static char iif(boolean condition, char resultTrue, char resultFalse) {
        if (condition) {
            return (resultTrue);
        }
        return (resultFalse);
    }

    public static String quotedStr(char ch) {
        return ("'" + ch + "'");
    }

    public static String quotedStr(String str) {
        return ("'" + str + "'");
    }

    public static void information(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    public static int confirmation(String message, String title) {
        //Yes = 0; No = 1
        return(JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION));
    }
}
