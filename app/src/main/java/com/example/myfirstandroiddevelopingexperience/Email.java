package com.example.myfirstandroiddevelopingexperience;

import java.util.ArrayList;

/**
 * Created by Seyyed Parsa Neshaei on 7/31/20
 * All Rights Reserved
 */
public class Email {
    private int id = 0;
    private String sender = "";
    private String subject = "";
    private String body = "";
    private String imageURL = "";

    public Email() {
    }

    public Email(int id, String sender, String subject, String body, String imageURL) {
        this.id = id;
        this.sender = sender;
        this.subject = subject;
        this.body = body;
        this.imageURL = imageURL;
    }

    static ArrayList<Email> allEmailActivities = new ArrayList<>();

    public static ArrayList<Email> getAllEmails() {
        if (allEmailActivities.isEmpty()) {
            allEmailActivities.add(new Email(1, "info@madeinlobby.ir", "Made In Lobby Mobile started",
                    "Thank you for joining us!", "http://spneshaei.com/mil/milimage.png")); //I messed up this link to demonstrate the progress bar I added :D Original link : "http://spneshaei.com/mil/milimage1.png"
            allEmailActivities.add(new Email(2, "spneshaei@madeinlobby.ir", "I am Parsa",
                    "Welcome to Made In Lobby!", "http://spneshaei.com/mil/milimage2.png"));
            allEmailActivities.add(new Email(3, "developer@google.com", "New Android SDK Released",
                    "Please check out the new SDK at Android Developer website", "http://spneshaei.com/mil/milimage3.png"));
            allEmailActivities.add(new Email(4, "madeinlobby@ce.sharif.edu", "Introducing MadeInLobby.ir",
                    "Please check out madeinlobby.ir :)", "http://spneshaei.com/mil/milimage4.png"));
        }
        return allEmailActivities;
    }

    public static void setAllEmailActivities(ArrayList<Email> newAllEmailActivities) {
        allEmailActivities = newAllEmailActivities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getImageURL() {
        return imageURL;
    }
}