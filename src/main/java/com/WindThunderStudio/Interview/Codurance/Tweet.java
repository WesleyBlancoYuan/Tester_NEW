package com.WindThunderStudio.Interview.Codurance;

import java.util.Date;

public class Tweet {
    private Date date;
    private User user;
    protected Date getDate() {
        return date;
    }
    protected void setDate(Date date) {
        this.date = date;
    }
    protected User getUser() {
        return user;
    }
    protected void setUser(User user) {
        this.user = user;
    }
    
    public Tweet() {
        
    }
    
}
