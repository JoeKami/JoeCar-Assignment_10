package com.coderscampus.assignment10.domain;

public class DayMeals {
    private String numCalories;
    private String diet;
    private String exclusions;

    public DayMeals() {
    }

    public String getNumCalories() {
        return numCalories;
    }

    public void setNumCalories(String numCalories) {
        this.numCalories = numCalories;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    @Override
    public String toString() {
        return "DayMeals{" +
                "numCalories='" + numCalories + '\'' +
                ", diet='" + diet + '\'' +
                ", exclusions='" + exclusions + '\'' +
                '}';
    }
}
