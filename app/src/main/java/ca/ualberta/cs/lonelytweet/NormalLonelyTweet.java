package ca.ualberta.cs.lonelytweet;

import java.util.Date;

public class NormalLonelyTweet extends LonelyTweet {
    public NormalLonelyTweet(String text, Date date) {}

    public boolean isValid() {
        // Simplified logic and control flow (using DeMorgan's law)
        return tweetBody.trim().length() != 0
                && tweetBody.trim().length() <= 10;
    }

    public String getTweetBody() {
        return tweetBody.toUpperCase();
    }
}
