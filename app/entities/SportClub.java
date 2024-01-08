package entities;


import java.io.Serializable;
import java.util.Objects;

// because we don't create objects for this class
public abstract class SportClub implements Serializable {
    private String name;
    private Address location;
    private int totalMemberCount;

    public SportClub(String name, Address location, int count){
        this.name = name;
        this.location = location;
        this.totalMemberCount = count;

    }

    // setter method of this class
    public void setName(String name){
        this.name = name;

    }

    public void setLocation(Address location){
        this.location = location;

    }

    public void setTotalMemberCount(int count){
        this.totalMemberCount = count;

    }

    // getter method of this class
    public String getName(){
        return name;

    }

    public Address getLocation(){
        return location;

    }

    public int getTotalMemberCount(){
        return totalMemberCount;

    }

    @Override
    public String toString(){
        return "Name of the club : " + name + "\nAddress : " + location + "\nTotal Member Count : " + totalMemberCount;

    }

    // this override methods help to sort the sport club
    @Override
    public boolean equals(Object club) {
        if (this == club) return true;
        if (club == null || getClass() != club.getClass()) return false;
        SportClub sportClub = (SportClub) club;
        return name.equals(sportClub.name) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
