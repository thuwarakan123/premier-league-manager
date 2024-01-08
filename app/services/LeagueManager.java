package services;

import java.io.IOException;
import entities.FootballClub;
import entities.Match;
import java.util.ArrayList;

public interface LeagueManager {

        public void addClub(FootballClub club);
        public boolean deleteClub(int clubID);
        public boolean printClubDetails(int clubID);
        public void printTable();
        public ArrayList<Object> getClub(int id);
        public void addMatch(Match match);
        public void addFile(String fileName) throws IOException;
        public void loadData(String fileName) throws IOException, ClassNotFoundException;

    }


