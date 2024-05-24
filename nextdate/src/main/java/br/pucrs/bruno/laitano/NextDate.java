package br.pucrs.bruno.laitano;

public final class NextDate {
    private String input;

    public NextDate(String input){
        this.input=input;
    }

    public boolean sizeValidation(){
        if (input.length()!=10)
            return false;
        return true;
    }

    public boolean digitsValidation(){
        if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1)) || !Character.isDigit(input.charAt(3))
                || !Character.isDigit(input.charAt(4)) || !Character.isDigit(input.charAt(6)) || !Character.isDigit(input.charAt(7))
                || !Character.isDigit(input.charAt(8)) || !Character.isDigit(input.charAt(9)))
            return false;
        return true;
    }

    public boolean formatValidation(){
        if (input.charAt(2)!='/' || input.charAt(5)!='/')
            return false;
        return true;
    }

    public boolean dayValidation(){
        int d = Integer.parseInt(input.substring(0,2));
        if (d<1 || d>31){
            return false;
        }
        return true;
    }

    public boolean monthValidation(){
        int m = Integer.parseInt(input.substring(3,5));
        if (m<1 || m>12){
            return false;
        }
        return true;
    }

    public boolean yearValidation(){
        int y = Integer.parseInt(input.substring(6,10));
        if (y<1600 || y>9998){
            return false;
        }
        return true;
    }

    boolean isLeapYear(int year) {
        if (year%4==0) {
            if (year%100==0)
                return year%400==0;
            else
                return true;
        }
        else
            return false;
    }

    public String nextDate() {
        int d = Integer.parseInt(input.substring(0, 2));
        int m = Integer.parseInt(input.substring(3, 5));
        int y = Integer.parseInt(input.substring(6, 10));
    
        boolean leapYear = isLeapYear(y);
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (leapYear) {
            daysInMonth[1] = 29;
        }

        d++;
    
        if (d>daysInMonth[m-1]) {
            d = 1;
            m++;
            if (m>12) {
                m = 1;
                y++;
            }
        }
    
        return String.format("%02d/%02d/%04d", d, m, y);
    }
}