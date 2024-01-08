package entities;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;

    }

    //setter methods
    public void setDay(int day){
        this.day = day;

    }

    public void setMonth(int month){
        this.month = month;

    }

    public void setYear(int year){
        this.year = year;

    }

    //getter method
    public int getDate(){
        return day;

    }

    public int getMonth(){
        return month;

    }

    public int getYear(){
        return year;

    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%s",day,month,year);

    }

    public boolean check(Date date){
        return day == date.getDate() && month == date.getMonth() && year == date.getYear();
    }

}
