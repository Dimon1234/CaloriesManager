package com.project.model;


import java.time.LocalDateTime;

public class UserMealWithExceed {
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final boolean isExceed;

    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, boolean isExceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.isExceed = isExceed;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExceed() {
        return isExceed;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", isExceed=" + isExceed +
                '}';
    }
}
