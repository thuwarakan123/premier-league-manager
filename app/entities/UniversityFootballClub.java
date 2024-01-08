package entities;

public class UniversityFootballClub extends FootballClub {
        private String universityName;


        public UniversityFootballClub(int win, int draw, int defeat, int receivedGoal, int scoredGoal, int point,
                                      int playedMatches, Address location, String name, int count, String universityName) {
            super(win, draw, defeat, receivedGoal, scoredGoal, point, playedMatches, location, name, count);
            this.universityName = universityName;
        }

        public String getUniversityName() {
            return universityName;

        }

        public void setUniversityName(String schoolName) {
            this.universityName = schoolName;

        }

        @Override
        public String toString() {
            return  super.toString()+ "\nschoolName= " + universityName;

        }

}

