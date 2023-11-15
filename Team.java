package com.company;
//Imonge Makaluza
//4008241

public class Team {
    String teamName;
    int teamNumber ;
    long regYear;
    int firstScore ;
    int secondScore ;
    double finalScore ;


    public Team(String teamName,int teamNumber,long regYear,int firstScore ,int secondScore) {
        this.teamName = teamName;
        this.teamNumber = teamNumber;
        this.regYear = regYear;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.finalScore =  (((double)firstScore  + (double) secondScore)/2);
    }
}
