package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {
    Address loc = new Address("12","sdgfh","stweywj");
    FootballClub fb1 = new FootballClub(12,1,1,31,22,10,5,loc,"ghfgh",12);
    FootballClub fb2 = new FootballClub(13,1,1,41,32,0,5,loc,"ghfcgggh",120);
    Date date = new Date(12,11,2020);
    Match match = new Match(fb1,fb2,12,11,date,fb1.getName(), fb2.getName());

    @Test
    public void getClub1() {
        assertEquals(fb1,match.getClub1());
    }

    @Test
    public void getClub2() {
        assertEquals(fb2,match.getClub2());
    }

    @Test
    public void getClub1Goal() {
        assertEquals(12,match.getClub1Goal());
    }

    @Test
    public void getClub2Goal() {
        assertEquals(11,match.getClub2Goal());
    }

    @Test
    public void getMatchDate() {
        assertEquals(date,match.getMatchDate());
    }

    @Test
    public void getClub1Name() {
        assertEquals("ghfgh",match.getClub1Name());
    }

    @Test
    public void getClub2Name() {
        assertEquals("ghfcgggh",match.getClub2Name());
    }

}