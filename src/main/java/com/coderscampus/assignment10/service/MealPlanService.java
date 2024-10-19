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

    public MealPlanService() {
    }

    private final RestTemplate restTemplate = new RestTemplate();

    public DayResponse getDailyMeals(String numCalories, String diet, String exclusions) {

        String apiUrl = spoonacularBaseUrl + spoonacularMealPlanUrl;

        if (numCalories != null && diet != null && exclusions != null) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                    .queryParam("timeFrame", "day")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet)
                    .queryParam("exclude", exclusions)
                    .queryParam("apiKey", apiKey);

            String finalUrl = uriComponentsBuilder.toUriString();
            ResponseEntity<DayResponse> response = restTemplate.getForEntity(finalUrl, DayResponse.class);
            return response.getBody();
        }
        if (numCalories == null && diet != null && exclusions != null) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                    .queryParam("timeFrame", "day")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet)
                    .queryParam("exclude", exclusions)
                    .queryParam("apiKey", apiKey);

            String finalUrl = uriComponentsBuilder.toUriString();
            ResponseEntity<DayResponse> response = restTemplate.getForEntity(finalUrl, DayResponse.class);
            return response.getBody();
        }
        if (numCalories != null && diet == null && exclusions != null) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                    .queryParam("timeFrame", "day")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet)
                    .queryParam("exclude", exclusions)
                    .queryParam("apiKey", apiKey);

            String finalUrl = uriComponentsBuilder.toUriString();
            ResponseEntity<DayResponse> response = restTemplate.getForEntity(finalUrl, DayResponse.class);
            return response.getBody();
        }
        if (numCalories != null && diet != null && exclusions == null) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                    .queryParam("timeFrame", "day")
                    .queryParam("targetCalories", numCalories)
                    .queryParam("diet", diet)
                    .queryParam("exclude", exclusions)
                    .queryParam("apiKey", apiKey);

            String finalUrl = uriComponentsBuilder.toUriString();
            ResponseEntity<DayResponse> response = restTemplate.getForEntity(finalUrl, DayResponse.class);
            return response.getBody();
        }
        if (numCalories == null && diet == null && exclusions == null) {}

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("timeFrame", "day")
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .queryParam("apiKey", apiKey);

        String finalUrl = uriComponentsBuilder.toUriString();
        ResponseEntity<DayResponse> response = restTemplate.getForEntity(finalUrl, DayResponse.class);
        return response.getBody();
    }

    public WeekResponse getWeeklyMeals(String numCalories, String diet, String exclusions) {
        String apiUrl = spoonacularBaseUrl + spoonacularMealPlanUrl;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("timeFrame", "week")
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .queryParam("apiKey", apiKey);

        String finalUrl = uriComponentsBuilder.toUriString();
        ResponseEntity<WeekResponse> response = restTemplate.getForEntity(finalUrl, WeekResponse.class);
        return response.getBody();
    }

   //Example
    //https://api.spoonacular.com/mealplanner/generate?timeFrame=day&targetCalories=4000&diet=Vegan&exclude=&apiKey=c8908a61851c46d7a6706b1f5f40d8c5
}
