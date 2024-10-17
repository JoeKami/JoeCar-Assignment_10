package com.coderscampus.assignment10.service;


import com.coderscampus.assignment10.domain.DayMeals;
import com.coderscampus.assignment10.domain.WeekMeals;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MealPlanService {


    private DayMeals dayMeals;
    private WeekMeals weekMeals;

    @Value("${spoonacular.urls.base}")
    private String spoonacularBaseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String spoonacularMealPlanUrl;

    @Value("${spoonacular.api.key}")
    private String apiKey;

    public DayMeals getDayMeals() {
        return dayMeals;
    }

    public void setDayMeals(DayMeals dayMeals) {
        this.dayMeals = dayMeals;
    }

    public WeekMeals getWeekMeals() {
        return weekMeals;
    }

    public void setWeekMeals(WeekMeals weekMeals) {
        this.weekMeals = weekMeals;
    }

    public MealPlanService() {
    }

    private final RestTemplate restTemplate = new RestTemplate();

    public DayMeals getDailyMeals (@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions) {
        String apiUrl = spoonacularBaseUrl + spoonacularMealPlanUrl;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("timeFrame" , "day")
                .queryParam("targetCalories" , numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude" , exclusions)
                .queryParam("apiKey", apiKey);

        ResponseEntity<DayMeals> response = restTemplate.getForEntity(uriComponentsBuilder, DayMeals.class)
                .
    }
}
