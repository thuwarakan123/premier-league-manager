package entities;

public class SchoolFootballClub extends FootballClub {
    private String schoolName;

    public SchoolFootballClub(int win, int draw, int defeat, int receivedGoal, int scoredGoal,
                              int point, int playedMatches, Address location, String name, int count, String schoolName) {
        super(win, draw, defeat, receivedGoal, scoredGoal, point, playedMatches, location, name, count);
        this.schoolName = schoolName;

    }

    public String getSchoolName() {
        return schoolName;

    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;

    }

    @Override
    public String toString() {
        return super.toString() + "\nschoolName= " + schoolName;

    }


}

