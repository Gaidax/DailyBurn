package com.example.dailyburn;

public class FeedBackInfo {

    private int feedbackId;
    private String feedbackYes;
    private String feedbackNo;


    public FeedBackInfo(int i, String string, String cursorString, int parseInt) {
    }

    public FeedBackInfo(int _feedbackId, String _feedbackYes, String _feedbackNo) {
        this.feedbackId = _feedbackId;
        this.feedbackYes = _feedbackYes;
        this.feedbackNo = _feedbackNo;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId() {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackYes() {
        return feedbackYes;
    }

    public void setFeedbackYes() {
        this.feedbackYes = feedbackYes;
    }

    public String getFeedbackNo() {
        return feedbackNo;
    }

    public void setFeedbackNo() {
        this.feedbackNo = feedbackNo;
    }
}