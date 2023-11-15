package com.company;
//Imonge Makaluza
//4008241
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TournamentEntry {
    private Node head;
    private int size;
    private Team[] teamArray;

    public void registerTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many teams do you want to register");
        System.out.print(">");
        int numberOfTeams = scanner.nextInt();

        System.out.println("Enter the attributes of the team or teams you want to register");
        for (int i = 0; i < numberOfTeams; i++) {
            var team = userInputForTeam();
            var node = new Node(team);
            if (head == null) {
                head = node;
                continue;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size = numberOfTeams;
    }

    public Team deregister_Last_team() {
        if (head == null)
            throw new NoSuchElementException();
        Node second_last = head;
        while (second_last.next.next != null) {
            second_last = second_last.next;
        }
        var lastTeam = second_last.next;
        second_last.next = null;
        size--;
        return lastTeam.team;

    }

    public Team deregister_Particular_team(int teamNumber) {
        var current = head;
        while (current.next != null) {
            if (current.next.team.teamNumber == teamNumber) {
                var deregisterTeam = current.next;
                current.next = current.next.next;
                return deregisterTeam.team;
            }
            current = current.next;
        }
        size--;
        return null;
    }

    public void insertBefore(int teamNumber, Team newTeam) {
        var node = new Node(newTeam);
        var current = head;
        while (current != null) {
            if (current.team.teamNumber == teamNumber) {
                var previous = getPrevious(current);
                previous.next = node;
                node.next = current;
                break;
            }
            current = current.next;

        }
        size++;
    }

    public int tournamentEntrySize() {
        return size;
    }

    private Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void Display() {
        toArray();
        var array = teamArray;
        for(int i= 0; i< array.length;i++){
            System.out.println(array[i].teamName +" "+ array[i].teamNumber +" "+ array[i].regYear +" "+ array[i].firstScore+" "+ array[i].secondScore+" "+array[i].finalScore);
        }

    }
    private Team userInputForTeam(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(">");
        String teamName = scanner.next();int teamNumber = scanner.nextInt();long regYear = scanner.nextLong();int firstScore = scanner.nextInt();int secondScore = scanner.nextInt();
        Team team = new Team(teamName,teamNumber,regYear,firstScore,secondScore);
        return team;
    }
    private Team[] toArray() {
        Team[] result = new Team[size];
        int i = 0;
        for (Node x = head; x != null; x = x.next)
            result[i++] = x.team;
        teamArray = result;
        return result;
    }
    public Team[] sort(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the attribute that you want to sort the teams with");
        System.out.print(">");
        String sortingAttribute = scanner.next();
        var array = toArray();
        for(var i = 0; i <array.length; i++)
            for (var j = 1; j < array.length; j++){
                if(sortingAttribute.equals("teamNumber"))
                    if(array[j].teamNumber > array[j-1].teamNumber)
                        swap(array,j,j-1);
                else if(sortingAttribute.equals("regYear"))
                    if(array[j].regYear > array[j-1].regYear)
                        swap(array,j,j-1);
                else if(sortingAttribute.equals("firstScore"))
                    if(array[j].firstScore > array[j-1].firstScore)
                        swap(array,j,j-1);
                else if(sortingAttribute.equals("secondScore"))
                    if(array[j].secondScore > array[j-1].secondScore)
                        swap(array,j,j-1);
                else if(sortingAttribute.equals("teamName"))
                    if(array[j].teamName.compareTo(array[j-1].teamName)<0)
                        swap(array,j,j-1);
                else
                    if (array[j].finalScore == array[j-1].finalScore && array[j].teamName.compareTo(array[j-1].teamName) != 0)
                        if(array[j].teamName.compareTo(array[j-1].teamName)<0)
                            swap(array,j,j-1);
                    if (array[j].finalScore == array[j-1].finalScore && array[j].teamName.compareTo(array[j-1].teamName) == 0)
                        if(array[j].teamNumber < array[j-1].teamNumber)
                            swap(array,j,j-1);
                        if(array[j].finalScore > array[j-1].finalScore)
                            swap(array,j,j-1);
            }
        for(int i= 0; i< array.length;i++){
            System.out.println(array[i].teamName +" "+ array[i].teamNumber +" "+ array[i].regYear +" "+ array[i].firstScore+" "+ array[i].secondScore+" "+array[i].finalScore);
        }
        teamArray = array;
        return array;
    }
    private void swap(Team[] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
