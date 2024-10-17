package com.coderscampus.assignment10.service;


import com.coderscampus.assignment10.domain.DayMeals;
import com.coderscampus.assignment10.domain.WeekMeals;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MealPlanService {

    @Value("${spoonacular.urls.base}")
    private String spoonacularBaseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String spoonacularMealPlanUrl;

    @Value("${spoonacular.api.key}")
    private String apiKey;

    public MealPlanService() {
    }

    private final RestTemplate restTemplate = new RestTemplate();

    public DayMeals getDailyMeals(String numCalories, String diet, String exclusions) {

        String apiUrl = spoonacularBaseUrl + spoonacularMealPlanUrl;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("timeFrame", "day")
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .queryParam("apiKey", apiKey);

        String finalUrl = uriComponentsBuilder.toUriString();
        ResponseEntity<DayMeals> response = restTemplate.getForEntity(finalUrl, DayMeals.class);

        DayMeals dayMeals = new DayMeals();
        dayMeals.setDiet(diet);
        dayMeals.setNumCalories(numCalories);
        dayMeals.setExclusions(exclusions);
        return dayMeals;
    }

    public WeekMeals getWeeklyMeals(String numCalories, String diet, String exclusions) {
        String apiUrl = spoonacularBaseUrl + spoonacularMealPlanUrl;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("timeFrame", "week")
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .queryParam("apiKey", apiKey);

        String finalUrl = uriComponentsBuilder.toUriString();
        ResponseEntity<WeekMeals> response = restTemplate.getForEntity(finalUrl, WeekMeals.class);

        WeekMeals weekMeals = new WeekMeals();
        weekMeals.setNumCalories(numCalories);
        weekMeals.setDiet(diet);
        weekMeals.setExclusions(exclusions);
        return weekMeals;
    }

    //This URL was the one that worked instead of 'localhost:8080'
    //It includes the parameters fields for timeFrame, targetCalories, diet, exclusions(empty), and my API Key
    //https://api.spoonacular.com/mealplanner/generate?timeFrame=day&targetCalories=4000&diet=Vegan&exclude=&apiKey=c8908a61851c46d7a6706b1f5f40d8c5
}
