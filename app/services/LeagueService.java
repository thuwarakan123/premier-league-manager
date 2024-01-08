package services;
import entities.FootballClub;
import entities.Match;
import entities.Date;

import java.io.*;
import java.util.*;

public class LeagueService {
    private static LeagueService instance;

    public static LeagueService getInstance() {
        if (instance == null) {
            instance = new LeagueService();
        }
        return instance;
    }

    public ArrayList<FootballClub> getClub() throws IOException {
        ArrayList<FootballClub> clubs = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("Data.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for (; ; ) {
            try {
                FootballClub club = (FootballClub) objectInputStream.readObject();
                clubs.add(club);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();
        Collections.sort(clubs);

        return clubs;

    }

    public ArrayList<Match> getMatch() throws IOException {
        ArrayList<Match> matches = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("Match.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for (; ; ) {
            try {
                Match match = (Match) objectInputStream.readObject();
                matches.add(match);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();

        return matches;
    }

    public ArrayList<FootballClub> getWinClub() throws IOException {
        ArrayList<FootballClub> clubWin = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("Data.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for (; ; ) {
            try {
                FootballClub club = (FootballClub) objectInputStream.readObject();
                clubWin.add(club);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();
        int length = clubWin.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - (i + 1); j++) {
                if (clubWin.get(j).getWin() < clubWin.get(j + 1).getWin()) {
                    FootballClub part = clubWin.get(j);
                    clubWin.set(j, clubWin.get(j + 1));
                    clubWin.set(j + 1, part);
                }
            }
        }
        return clubWin;

    }

    public ArrayList<FootballClub> getScoreClub() throws IOException {
        ArrayList<FootballClub> clubScore = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("Data.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for (; ; ) {
            try {
                FootballClub club = (FootballClub) objectInputStream.readObject();
                clubScore.add(club);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();
        int length = clubScore.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - (i + 1); j++) {
                if (clubScore.get(j).getScoredGoal() < clubScore.get(j + 1).getScoredGoal()) {
                    FootballClub part = clubScore.get(j);
                    clubScore.set(j, clubScore.get(j + 1));
                    clubScore.set(j + 1, part);
                }
            }
        }
        return clubScore;

    }

//    public Match randomMatch() throws IOException, ClassNotFoundException{
//        ArrayList<FootballClub> clubs = new ArrayList<>();
//
//        FileInputStream fileInputStream = new FileInputStream("Data.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//        for (; ; ) {
//            try {
//                FootballClub club = (FootballClub) objectInputStream.readObject();
//                clubs.add(club);
//            } catch (EOFException | ClassNotFoundException e) {
//                break;
//            }
//        }
//        fileInputStream.close();
//        objectInputStream.close();
//
//        ArrayList<Match> matches = new ArrayList<>();
//
//        FileInputStream fileInputStream1 = new FileInputStream("Match.txt");
//        ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
//
//        for (; ; ) {
//            try {
//                Match match = (Match) objectInputStream1.readObject();
//                matches.add(match);
//            } catch (EOFException | ClassNotFoundException e) {
//                break;
//            }
//        }
//        fileInputStream.close();
//        objectInputStream.close();
//        final PremierLeagueManager manager = new PremierLeagueManager(20);
//
//        for(Match match : matches){
//            manager.addMatch(match);
//        }
//
//
//        int goal1count = (int)(Math.random() * 10) + 1;
//        int goal2count = (int)(Math.random() * 10) + 1;
//        int year = 2020;
//        int month = (int)(Math.random() * 12) + 1;
//        int day = (int)(Math.random() * 28) + 1;
//
//        FootballClub MatchClub1 = getRandomClub(clubs);
//        FootballClub MatchClub2 = getRandomClub(clubs);
//        while(MatchClub1.getClubID() == MatchClub2.getClubID()){
//            MatchClub2 = getRandomClub(clubs);
//        }
//
//        Date dateOfMatch =new Date (day,month,year);
//        Match matchObj = new Match(MatchClub1,MatchClub2,goal1count,goal2count,dateOfMatch,MatchClub1.getName(),MatchClub2.getName());
//        manager.addMatch(matchObj);
//        manager.addFileMatch("Match.txt");
//        return matchObj;
//
//    }
//
//    public FootballClub getRandomClub(ArrayList<FootballClub> premierLeague){
//        int max = premierLeague.size() ;
//        int clubIndex = (int)(Math.random() * max)+1;
//        return  premierLeague.get(clubIndex - 1);
//    }
//
//
}
