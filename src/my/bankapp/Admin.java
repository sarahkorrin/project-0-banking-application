package my.bankapp;

import java.io.Serializable;

public class Admin implements Serializable
{
    public String getAdminUsername()
    {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername)
    {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword()
    {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword)
    {
        this.adminPassword = adminPassword;
    }

    public String getAdminFirstName()
    {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName)
    {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName()
    {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName)
    {
        this.adminLastName = adminLastName;
    }

    String adminUsername;
    String adminPassword;
    String adminFirstName;
    String adminLastName;

}
