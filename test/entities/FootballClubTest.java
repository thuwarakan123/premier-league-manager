package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {
    FootballClub fb = new FootballClub(12,1,0,23,23,
            1,12 ,new Address("12","sdgsd","fgd"),"sfsf",1200);



    @Test
    public void getWin() {
        assertEquals(12,fb.getWin());
    }

    @Test
    public void getDraw() {
        assertEquals(1,fb.getDraw());
    }

    @Test
    public void getDefeat() {
        assertEquals(0,fb.getDefeat());
    }

    @Test
    public void getReceivedGoal() {
        assertEquals(23,fb.getReceivedGoal());
    }

    @Test
    public void getScoredGoal() {
        assertEquals(23,fb.getScoredGoal());
    }

    @Test
    public void getPoint() {
        assertEquals(1,fb.getPoint());
    }

    @Test
    public void getPlayedMatches() {
        assertEquals(12,fb.getPlayedMatches());
    }


}