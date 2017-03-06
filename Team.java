package com.cs60333.mpenny2.lab2_mpenny2;
import java.io.Serializable;

/**
 * Created by michaelpenny on 3/1/17.
 */

public class Team implements Serializable{
    String teamName;
    String teamlogo;
    String abvDate;
    String longDate;
    String stadium;
    String score;
    String record;

    public Team (String[] info) {
        setTeamName(info[1]);
        setTeamLogo(info[0]);
        setAbvDate(info[2]);
        setLongDate(info[3]);
        setStadium(info[4]);
        setScore(info[5]);
        setRecord(info[6]);

    }

    public void setTeamName(String team_name) {
        this.teamName = team_name;
    }
    public String getTeamName() {
        return this.teamName;
    }

    public String getTeamLogo() {
        return this.teamlogo;
    }
    public void setTeamLogo(String x) {
        this.teamlogo = x;
    }

    public String getAbvDate() {
        return this.abvDate;
    }
    public void setAbvDate(String abvDate) {
        this.abvDate = abvDate;
    }
    public String getLongDate() {
        return this.longDate;
    }
    public void setLongDate(String longDate) {
        this.longDate = longDate;
    }
    public String getStadium() {
        return this.stadium;
    }
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getScore() {
        return this.score;
    }
    public void setScore(String score) {
        this.score = score;
    }

    public String getRecord() {
        return this.record;
    }
    public void setRecord(String record) {
        this.record = record;
    }
}
