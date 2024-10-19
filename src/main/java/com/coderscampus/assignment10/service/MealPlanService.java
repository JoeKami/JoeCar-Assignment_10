package com.coderscampus.assignment10.service;


import com.coderscampus.assignment10.domain.DayResponse;
import com.coderscampus.assignment10.domain.WeekResponse;
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

    private final RestTemplate restTemplate = new RestTemplate();

    public DayResponse getDailyMeals(String numCalories, String diet, String exclusions) {

        ResponseEntity<DayResponse> response = restTemplate.getForEntity(buildFinalUrl("day", numCalories, diet, exclusions), DayResponse.class);
        return response.getBody();
    }

    public WeekResponse getWeeklyMeals(String numCalories, String diet, String exclusions) {

        ResponseEntity<WeekResponse> response = restTemplate.getForEntity(buildFinalUrl("week", numCalories, diet, exclusions), WeekResponse.class);
        return response.getBody();
    }

    public String buildFinalUrl(String timeFrame, String numCalories, String diet, String exclusions) {

        String apiUrl = spoonacularBaseUrl + spoonacularMealPlanUrl;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("timeFrame", timeFrame)
                .queryParam("apiKey", apiKey);

        if (numCalories != null && !numCalories.isEmpty()) {
            uriComponentsBuilder.queryParam("targetCalories", numCalories);
        }

        if (diet != null && !diet.isEmpty()) {
            uriComponentsBuilder.queryParam("diet", diet);
        }

        if (exclusions != null && !exclusions.isEmpty()) {
            uriComponentsBuilder.queryParam("exclude", exclusions);
        }

        String finalUrl = uriComponentsBuilder.toUriString();
        System.out.println("Final URL: " + finalUrl);
        return finalUrl;
    }
}
