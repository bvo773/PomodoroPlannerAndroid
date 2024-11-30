package com.vo.binh.pomo;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Task implements Serializable {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mCompleted;

    // Default constructor
    public Task() {
        this.mId = UUID.randomUUID();
        this.mDate = new Date();
        this.mTitle = "";
        this.mCompleted = false;
    }

    // Constructor with parameters
    public Task(String title, Date date, boolean completed) {
        this.mId = UUID.randomUUID();
        this.mTitle = title;
        this.mDate = date;
        this.mCompleted = completed;
    }

    // Getter and Setter for ID
    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        this.mId = id;
    }

    // Getter and Setter for Title
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    // Getter and Setter for Date
    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    // Getter and Setter for Completed status
    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        this.mCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mDate=" + mDate +
                ", mCompleted=" + mCompleted +
                '}';
    }
}
