package com.coderscampus.assignment10.domain;

import java.util.Map;

public class WeekResponse {
    private Map<String, DayResponse> week;

    public WeekResponse() {
    }

    public Map<String, DayResponse> getWeek() {
        return week;
    }

    public void setWeek(Map<String, DayResponse> week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "WeekResponse{" +
                "week=" + week +
                '}';
    }
}
