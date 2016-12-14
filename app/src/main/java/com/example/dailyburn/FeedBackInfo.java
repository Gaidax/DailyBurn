package com.example.dailyburn;

public class FeedBackInfo {

    private int feedbackId;
    private String response;
    private int profileId;

    public FeedBackInfo (){}

    public FeedBackInfo (int feedbackId, int profileId, String response ){
        this.feedbackId = feedbackId;
        this.response = response;
        this.profileId = profileId;
    }

    public int getFeedbackId()
    {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId)
    {
        this.feedbackId = feedbackId;
    }

    public String getResponse()
    {
        return response;
    }
    public void setResponse(String response)
    {
        this.response = response;
    }

    public int getProfileId()
    {
        return profileId;
    }
    public void setProfileId(int profileId)
    {
        this.profileId = profileId;
    }
}