package entities;

import java.io.Serializable;


public class FootballClub extends SportClub implements Serializable, Comparable<FootballClub> {
    // we use club id to identify each object and  it's unique for each objects.
    private int clubID;
    private int win;
    private int draw;
    private int defeat;
    private int receivedGoal;
    private int scoredGoal;
    // point also want to be a int value because it can't be a decimal value
    private int point;
    private int playedMatches;
    //this static attribute is store the number of total created numbers
    private static int totalObjects;


    public FootballClub(int win, int draw, int defeat, int receivedGoal, int scoredGoal, int point, int playedMatches, Address location, String name, int count){
        super(name,location,count);
        totalObjects = totalObjects + 1;
        this.win = win;
        this.draw = draw;
        this.defeat = defeat;
        this.receivedGoal = receivedGoal;
        this.scoredGoal = scoredGoal;
        this.point = point;
        this.playedMatches = playedMatches;
        this.clubID = 1000 + totalObjects;

    }

    //setter methods
    //clubID will automatically generate
    public void setWin(int win) {
        this.win = win;

    }

    public void setDraw(int draw) {
        this.draw = draw;

    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;

    }

    public void setReceivedGoal(int receivedGoal) {
        this.receivedGoal = receivedGoal;

    }

    public void setScoredGoal(int scoredGoal) {
        this.scoredGoal = scoredGoal;

    }

    public void setPoint(int point) {
        this.point = point;

    }

    public void setPlayedMatches(int playedMatches) {
        this.playedMatches = playedMatches;

    }

    public static void setTotalObjects(int totalObjects) {
        FootballClub.totalObjects = totalObjects;
    }

    // getter method
    public int getClubID() {
        return clubID;

    }

    public int getWin() {
        return win;

    }

    public int getDraw() {
        return draw;

    }

    public int getDefeat() {
        return defeat;

    }

    public int getReceivedGoal() {
        return receivedGoal;

    }

    public int getScoredGoal() {
        return scoredGoal;

    }

    public int getPoint() {
        return point;

    }

    public int getPlayedMatches() {
        return playedMatches;

    }

    @Override
    public String toString() {
        String details;
        details = super.toString()+"\nClub ID : "+ clubID + "\nPlayed Matches : " +playedMatches +"\nTotal Win : "+ win + "\nTotal Defeat : " + defeat + "\nTotal Draw : " + draw
                +"\nReceived Goal : " + receivedGoal + "\nScored Goal : " + scoredGoal + "\nTotal Point : " + point;
        return details;

    }


    @Override
    public int compareTo(FootballClub club) {
        int thisScore = scoredGoal - receivedGoal;
        int clubScore = club.getScoredGoal() - club.getReceivedGoal();
        if(point == club.getPoint()){
            if(thisScore > clubScore){
                return -1;
            }
            else if(thisScore < clubScore){
                return 1;
            }
            else{
                return 0 ;
            }
        }
        else if (point > club.getPoint()){
            return -1;
        }
        else{
            return 1;
        }
    }
}

