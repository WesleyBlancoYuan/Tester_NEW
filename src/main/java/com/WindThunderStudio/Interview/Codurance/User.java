package com.WindThunderStudio.Interview.Codurance;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Tweet> tweets;
    private List<User> followings;
    
    
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
    
    protected List<Tweet> getTweets() {
        return tweets;
    }

    protected void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    protected List<User> getFollowings() {
        return followings;
    }

    protected void setFollowings(List<User> followings) {
        this.followings = followings;
    }

    public User() {
        this.tweets = new ArrayList<>();
        this.followings = new ArrayList<>();
    }
    
    public User(String name) {
        this();
        this.name = name;
        
    }
    
    public void addTweet(Tweet tweet) {
        this.tweets.add(tweet);
    }
    
    public void follow(User user) {
        this.followings.add(user);
    }
}
