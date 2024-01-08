package services;

import entities.FootballClub;
import entities.Match;
import entities.SportClub;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PremierLeagueManager implements LeagueManager{
    private static final List<FootballClub> premierLeague = new ArrayList<>();
    private static final List<Match> matchList = new ArrayList<>();
    private final int totalTeams;

    public PremierLeagueManager (int count){
        this.totalTeams = count;
    }
    //add method
    public void addClub(FootballClub club){
        // check this club is already in the list
        for(SportClub league : premierLeague) {
            if (club.equals(league)) {
                System.out.println("This club already in the premier league\nplease add another club");
                return;
            }
        }
        if(premierLeague.size() < totalTeams){
            premierLeague.add(club);
            System.out.println("The club is Successfully added and The ID : "+club.getClubID());
        }
        else{
            System.out.println("The slot is full");
        }
    }
    //-------------------------------------------------------------------------------------------
    //deleting club
    public boolean deleteClub(int clubID){
        boolean flag = false;
        if(premierLeague.size() == 0){
            System.out.println("\nYour total Club count is 0 \nFirst add some Club");
            flag = true;
        }
        else{
            for(FootballClub club : premierLeague) {
                if (club.getClubID() == clubID) {
                    premierLeague.remove(club);
                    System.out.println("Football Club " + club.getName() + " is Successfully Deleted");
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    //-----------------------------------------------------------------------------------------
    //display details of particular club
    public boolean printClubDetails(int clubID){
        boolean flag = false;
        if(premierLeague.size() == 0) {
            System.out.println("\nYour total Club count is 0 \nFirst add some Club");
            flag = true;
        }
        else{
            for (FootballClub Club : premierLeague) {
                int check = Club.getClubID();
                if (clubID == check) {
                    System.out.println("\n"+ Club + "\n");
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    //------------------------------------------------------------------------------------------
    //print point table
    public void printTable() {
        if (premierLeague.size() == 0) {
            System.out.println("\nYour total Club count is 0 \nFirst add some Club");
        } else {
            System.out.println("                      Premier League Point Table\n");
            System.out.println("+--------------------------+-----------------+---------------------+----------------+-------------------+");
            System.out.printf("%s %20s %5s %10s  %5s %15s %5s %10s %5s %15s %3s%n", "|", "Club Name", "|", "Club Id", "|","Played Matches","|" ,"Point", "|", "Goal Different", "|");
            System.out.println("+--------------------------+-----------------+---------------------+----------------+-------------------+");
            Collections.sort(premierLeague);
            for (FootballClub footballClub : premierLeague) {
                System.out.printf("%s %20s %5s %10s  %5s %15s %5s %10s %5s %15s %3s%n", "|", footballClub.getName(), "|", footballClub.getClubID(),
                        "|", footballClub.getPlayedMatches(), "|", footballClub.getPoint(), "|", (footballClub.getScoredGoal() - footballClub.getReceivedGoal()), "|");
                //System.out.println("+---------------------+-----------------+---------------------+----------------+-------------------+");
            }
            System.out.println("+--------------------------+-----------------+---------------------+----------------+-------------------+");
        }
    }
    //------------------------------------------------------------------------------------------------
    //getClub method
    public  ArrayList<Object> getClub(int id){
        boolean flag = false;
        FootballClub club = null;
        for (FootballClub footballClub : premierLeague) {
            int check = footballClub.getClubID();
            if (check == id) {
                club = footballClub;
                flag = true;
                break;
            }
        }
        return new ArrayList<Object>(  Arrays.asList(club,flag));
    }
    //-------------------------------------------------------------------------------------------------
    //addMatch method
    public void addMatch(Match match){
        matchList.add(match);

        int club1Goal = match.getClub1Goal();
        int club2Goal = match.getClub2Goal();
        FootballClub club1 = match.getClub1();
        FootballClub club2 = match.getClub2();
        //set received and scored goals
        club1.setScoredGoal(club1.getScoredGoal() + club1Goal);
        club1.setReceivedGoal(club1.getReceivedGoal() + club2Goal);
        club2.setScoredGoal(club2.getScoredGoal() + club2Goal);
        club2.setReceivedGoal(club2.getReceivedGoal() + club1Goal);
        //update matches
        club1.setPlayedMatches(club1.getPlayedMatches() + 1);
        club2.setPlayedMatches(club2.getPlayedMatches() + 1);

        //check which club is win and update point,win,defeat,draw
        if(club1Goal > club2Goal){
            club1.setPoint(club1.getPoint() + 2);
            club1.setWin(club1.getWin() + 1);
            club2.setDefeat(club2.getDefeat() + 1);

        }
        else if(club1Goal < club2Goal){
            club2.setPoint(club2.getPoint() + 2);
            club2.setWin(club2.getWin() + 1);
            club1.setDefeat(club1.getDefeat() + 1);

        }
        else{
            club1.setPoint(club1.getPoint() + 1);
            club2.setPoint(club2.getPoint() + 1);
            club1.setDraw(club1.getDraw() + 1);
            club2.setDraw(club2.getDraw() + 1);

        }

    }
    //---------------------------------------------------------------------------------------------------------------
    //addFile method
    public void addFile(String fileName) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (FootballClub footballClub : premierLeague) {
            objectOutputStream.writeObject(footballClub);
        }

        objectOutputStream.flush();
        fileOutputStream.close();
        objectOutputStream.close();

        System.out.println("\nClub Data has been Successfully Saved to the Data File");
    }
    //---------------------------------------------------------------------------------------------------------------
    //getData method
    public void loadData(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for(;;) {
            try {
                FootballClub club = (FootballClub) objectInputStream.readObject();
                premierLeague.add(club);

            }
            catch (EOFException e) {
                break;
            }
        }
        FootballClub club = premierLeague.get(premierLeague.size() - 1);
        int count = club.getClubID() - 1000;
        FootballClub.setTotalObjects(count);

        fileInputStream.close();
        objectInputStream.close();

        System.out.println("\nClub Data has been Successfully Loaded from the File");
    }
    //---------------------------------------------------------------------------------------------------------------
    //add file method
    public void addFileMatch(String fileName) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Match match : matchList) {
            objectOutputStream.writeObject(match);
        }

        objectOutputStream.flush();
        fileOutputStream.close();
        objectOutputStream.close();

        System.out.println("\nMatch Data has been Successfully Saved to the Data File");
    }
    //---------------------------------------------------------------------------------------------------------------
    //getData method
    public void loadMatchData(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for(;;) {
            try {
                Match match = (Match) objectInputStream.readObject();
                matchList.add(match);
            }
            catch (EOFException e) {
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();
        System.out.println("\nMatch Data has been Successfully Loaded from the File");
    }
    //------------------------------------------------------------------------------------------------


}

