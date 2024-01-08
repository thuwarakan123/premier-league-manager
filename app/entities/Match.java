package entities;

import java.io.Serializable;

public class Match implements Serializable{
    private FootballClub club1;
    private FootballClub club2;
    private int club1Goal;
    private int club2Goal;
    private Date matchDate;
    private String club1Name;
    private String club2Name;
    private String stringDate;

    public Match(FootballClub club1, FootballClub club2, int club1Goal, int club2Goal, Date date, String name1, String name2) {
        this.club1 = club1;
        this.club2 = club2;
        this.club1Goal = club1Goal;
        this.club2Goal = club2Goal;
        this.matchDate = date;
        this.club1Name = name1;
        this.club2Name = name2;
        this.stringDate = date.toString();
    }

    public void setClub1(FootballClub club1) {
        this.club1 = club1;

    }

    public void setClub2(FootballClub club2) {
        this.club2 = club2;

    }

    public void setClub1Goal(int club1Goal) {
        this.club1Goal = club1Goal;

    }

    public void setClub2Goal(int club2Goal) {
        this.club2Goal = club2Goal;

    }

    public FootballClub getClub1() {
        return club1;

    }

    public FootballClub getClub2() {
        return club2;

    }

    public int getClub1Goal() {
        return club1Goal;

    }

    public int getClub2Goal() {
        return club2Goal;

    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getClub1Name() {
        return club1Name;
    }

    public void setClub1Name(String club1Name) {
        this.club1Name = club1Name;
    }

    public String getClub2Name() {
        return club2Name;
    }

    public void setClub2Name(String club2Name) {
        this.club2Name = club2Name;
    }

    public String getStringDate() {
        return stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }
}
