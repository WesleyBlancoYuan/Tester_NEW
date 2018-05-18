package com.WindThunderStudio.Interview.Codurance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Chatty {
    private Scanner sc;
    private String line;
    private Set<String> users;
    /* the posts by username */
    private Map<String, List<String>> posts;
    private Map<String, List<String>> followings;
    
    public Chatty() {
        this.sc = new Scanner(System.in);
        this.users = new HashSet<>();
        this.posts = new HashMap<>();
        this.followings = new HashMap<>();
    }
    
    public int readInput() {
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                return -1;
            }
            String[] splits = line.split(" ");
            if (splits.length == 1) { //check his/her posts
                reading(splits[0]);
            } else if (splits.length == 2) { //check his/her timeline
                wall(splits[0]);
            } else if (splits.length >= 3) {
                if (splits[1].equals("->")) {
                    posting(splits[0], line.substring(line.indexOf("->") + 3, line.length()));
                } else if (splits[1].equals("follows")) {
                    following(splits[0], splits[2]);
                }
            }
        }
        return 0;
    }
    
    private void reading(String username) {
        if (users.contains(username)) {
            List<String> tweets = posts.get(username);
            for (String t: tweets) {
                showTweet(t);
            }
        } else {
            System.out.println(); //no posts, new line
        }
    }
    /* shows your tweets and those who you follow */
    private void wall(String username) {
        if (users.contains(username)) {
            List<String> following = followings.get(username);
            if (following == null) {
                reading(username); //if no following, just show user1 posts
            } else {
                for (String follow: following) {
                    reading(follow);
                }
            }
            
            
        } else {
            noTweets();
        }
    }
    
    private void posting(String username, String tweet) {
        List<String> tweetsOfUser = new ArrayList<String>();
        if (users.contains(username)) {
            tweetsOfUser = (ArrayList<String>) posts.get(username);
            if (tweetsOfUser == null) {
                tweetsOfUser = new ArrayList<String>();
            }
        } else {
            users.add(username);
        }
        tweetsOfUser.add(tweet);
        posts.put(username, tweetsOfUser);
        showTweet(tweet);
    }
    
    private void following(String user1, String user2) {
        List<String> following = new ArrayList<String>();
        if (users.contains(user1)) {
            following = (ArrayList<String>) followings.get(user1);
            if (following == null) {
                following = new ArrayList<>();
            }
                
        } else {
            users.add(user1);
        }
        following.add(user2);
        followings.put(user1, following);
    }
    private void showTweet(String tweet) {
        System.out.println(tweet);
    }
    
    private void noTweets() {
        System.out.println();
    }
}
