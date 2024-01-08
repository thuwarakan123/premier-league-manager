package Console;

import entities.*;
import services.PremierLeagueManager;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class ConsoleMenu {
    private static final PremierLeagueManager manager = new PremierLeagueManager(20);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            manager.loadData("Data.txt");
            manager.loadMatchData("Match.txt");
        } catch (EOFException e) {
            System.out.println("FIle is empty");
        }catch(ArrayIndexOutOfBoundsException ae){
            System.out.println("File is empty");
        }
        //Application.launch(args);
        menu:
        while (true) {
            System.out.println("\n================== Welcome to the Premier League Management System ==================");
            System.out.println("\nYou can select which method you Want by Entering Number\n ");
            System.out.println("1 = Adding Clubs to Premier League");
            System.out.println("2 = Delete Club for Premier League");
            System.out.println("3 = print Club Details ");
            System.out.println("4 = print Point Table of Premier League");
            System.out.println("5 = add Match to Premier League");
            System.out.println("6 = Save and End the Programme");

            System.out.print("\nEnter the Method Number : ");
            try {
                Scanner input = new Scanner(System.in);
                int count = input.nextInt();

                switch (count) {
                    case 1:
                        FootballClub club;
                        System.out.println("Enter which type of club you want to add ?");
                        System.out.println("1 = Football Club");
                        System.out.println("2 = University Football Club");
                        System.out.println("3 = School Football Club");
                        System.out.print("Enter : ");
                        int select = input.nextInt();

                        if (select > 0 && select < 4) {

                            System.out.print("Enter club Name : ");
                            input.nextLine();
                            String Name = input.nextLine();

                            System.out.println("Now enter the address of club");
                            System.out.print("Enter the No : ");

                            String no = input.nextLine();
                            System.out.print("Enter the Street Name : ");

                            String street = input.nextLine();
                            System.out.print("Enter the City Name : ");
                            String city = input.nextLine();

                            int memberCount = checkInput("Enter the Member count of this club : ");

                            Address address = new Address(no, street, city);

                            switch (select) {
                                case 1:
                                    club = new FootballClub(0, 0, 0, 0, 0,
                                            0, 0, address, Name, memberCount);
                                    manager.addClub(club);
                                    break;
                                case 2:
                                    System.out.print("Enter University Name : ");
                                    input.nextLine();
                                    String uniName = input.nextLine();
                                    club = new FootballClub(3, 3, 3, 3, 3,
                                            3, 3, address, Name, memberCount);
                                    manager.addClub(club);
                                    break;
                                case 3:
                                    System.out.print("Enter School Name : ");
                                    input.nextLine();
                                    String schoolName = input.nextLine();
                                    club = new FootballClub(0, 0, 0, 0, 0,
                                            0, 0, address, Name, memberCount);
                                    manager.addClub(club);
                                    break;
                            }
                        } else {
                            System.out.println("\nYou Entered Invalid Number Please Enter Correct Number.");
                        }
                        break;
                    //--------------------------------------------------------------------------------------------------
                    case 2:
                        int clubID;
                        boolean flag ;
                        do {
                            System.out.print("Enter the club ID for Delete Club : ");
                            while (!input.hasNextInt()) {
                                System.out.print("That's not a number! Enter a Number for Delete Club : ");
                                input.next();
                            }
                            clubID = input.nextInt();
                            flag = manager.deleteClub(clubID);
                            if (!flag) {
                                System.out.println("Invalid Id Enter the correct ID");
                            }

                        } while (!flag);
                        break;
                    //----------------------------------------------------------------------------------------------
                    case 3:
                        int details;
                        boolean flag2 ;
                        do {
                            System.out.print("Enter the club ID for print details : ");
                            while (!input.hasNextInt()) {
                                System.out.print("That's not a number! Enter a Number for print Details : ");
                                input.next();
                            }
                            details = input.nextInt();
                            flag2 =manager.printClubDetails(details);
                            if (!flag2) {
                                System.out.println("Invalid Id Enter the correct ID");
                            }
                        } while (!flag2);
                        break;
                    //----------------------------------------------------------------------------------------------
                    case 4:
                        manager.printTable();
                        break;
                    //----------------------------------------------------------------------------------------------
                    case 5:
                        // get football clubs to add in a match
                        FootballClub matchClub1 = checkID("First");
                        FootballClub matchClub2 = checkID("Second");
                        //----------------------------------------------------------------
                        // check and get the goals of two teams
                        int goal1 = checkInput("Enter the first Team Goals : ") ;
                        int goal2 = checkInput("Enter the second5 Team Goals : ");

                        int year;
                        do {
                            System.out.print("Enter the Year : ");
                            while (!input.hasNextInt()) {
                                System.out.print("That's not a Year! Enter a correct year : ");
                                input.next();
                            }
                            year = input.nextInt();
                            if (year < 2019) {
                                System.out.println("You entered a wrong year ");
                            }
                        } while (year < 2019);
                        //---------------------------------------------------------
                        int month;
                        do {
                            System.out.print("Enter the month : ");
                            while (!input.hasNextInt()) {
                                System.out.print("Enter the month in Number format : ");
                                input.next();
                            }
                            month = input.nextInt();
                            if (month > 12 ||month < 0) {
                                System.out.println("The month is should be in 1 to 12");
                            }
                        } while (month > 12 || month < 0);
                        // -------------------------------------------------------------
                        int[] DaysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
                        int day;
                        do {
                            System.out.print("Enter the day : ");
                            while (!input.hasNextInt()) {
                                System.out.print("Enter the day in Number format : ");
                                input.next();
                            }
                            day = input.nextInt();
                            if (day >= DaysInMonth[month-1] || day<0) {
                                System.out.println("The day is should be in 1 to " + DaysInMonth[month-1]);
                            }
                        } while (day >= DaysInMonth[month-1] || day < 0);
                        //----------------------------------------------------------------

                        Date date = new Date(day, month, year);
                        Match match = new Match(matchClub1, matchClub2, goal1, goal2, date,matchClub1.getName(),matchClub2.getName());
                        manager.addMatch(match);
                        break;
                    //----------------------------------------------------------------------------------------------

                    //------------------------------------------------------------------------------------------------------
                    case 6:
                        manager.addFile("Data.txt");
                        manager.addFileMatch("Match.txt");
                        break menu;
                    //----------------------------------------------------------------------------------------------
                    default:
                        System.out.println("You entered a wrong number");
                }
            }
            catch(InputMismatchException e){
                System.out.println("The System only accept 'Integer' Value");
            }
        }
    }
    //-------------------------------------------------------------------------------------
    //check the id and return the football club
    public static FootballClub checkID(String number){
        FootballClub matchClub;
        boolean flag ;
        int club;
        do {
            System.out.print("Enter the " + number + " Team ID : ");
            Scanner input = new Scanner(System.in);
            while (!input.hasNextInt()) {
                System.out.print("ID should be in number format! Enter a Number for Delete Club : ");
                input.next();
            }
            club = input.nextInt();
            ArrayList<Object> p = manager.getClub(club);
            flag = (boolean) p.get(1);
            matchClub = (FootballClub) p.get(0);

            if (!flag) {
                System.out.println("Invalid Id Enter the correct ID");
            }
        } while (!flag);
        return matchClub;
    }
    //------------------------------------------------------------------------------------
    //check the integer inputs
    public static int checkInput(String Question){
        int number;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print(Question);
            while (!input.hasNextInt()) {
                System.out.print("That's not a number! Enter a Number value : ");
                input.next();
            }
            number = input.nextInt();
            if (number < 0) {
                System.out.println("Enter a positive value");
            }
        } while (number < 0);
        return number;
    }


}

