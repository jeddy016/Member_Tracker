package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberDetail
{
    @Id
    @Column
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String dateJoined;

    @Column
    private String volunteer;

    @Column
    private String chapter;

    @Column
    private String jobTitle;

    @Column
    private String company;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        String[] phoneArr = phone.split("");
        StringBuilder formattedPhone = new StringBuilder();

        for(int i= 0; i < phoneArr.length; i++)
        {
            if(i == 0) formattedPhone.append("(");

            if(i == 3) formattedPhone.append(") ");

            if(i == 6) formattedPhone.append("-");

            formattedPhone.append(phoneArr[i]);
        }

        return formattedPhone.toString();
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getDateJoined()
    {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined)
    {
        this.dateJoined = dateJoined;
    }

    public String getVolunteer()
    {
        return volunteer.equals("0") ? "No" : "Yes";
    }

    public void setVolunteer(String volunteer)
    {
        this.volunteer = volunteer;
    }

    public String getChapter()
    {
        return chapter;
    }

    public void setChapter(String chapter)
    {
        this.chapter = chapter;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }
}