package models;

import javax.persistence.*;

@Entity
@Table(name = "chapter")
public class Chapter
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="chapter_id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="meeting_place")
    private String meetingPlace;

    @Column(name="street_address")
    private String streetAddress;

    @Column(name="city")
    private String city;

    @Column(name="leader_id")
    private Integer leaderID;

    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getMeetingPlace()
    {
        return meetingPlace;
    }

    public String getStreetAddress()
    {
        return streetAddress;
    }

    public Integer getLeaderID()
    {
        return leaderID;
    }

    public String getCity()
    {
        return city;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setLeaderID(Integer leaderID)
    {
        this.leaderID = leaderID;
    }
}
