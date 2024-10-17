package com.coderscampus.assignment10.service;


import com.coderscampus.assignment10.domain.DayMeals;
import com.coderscampus.assignment10.domain.WeekMeals;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
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

    public DayMeals getDailyMeals (@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions) {
        String apiUrl = spoonacularBaseUrl + spoonacularMealPlanUrl;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("timeFrame" , "day")
                .queryParam("targetCalories" , numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude" , exclusions)
                .queryParam("apiKey", apiKey);

        String finalUrl = uriComponentsBuilder.toUriString();

        try {
            ResponseEntity<DayMeals> response = restTemplate.getForEntity(finalUrl, DayMeals.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to fetch daily meals: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Error calling Spoonacular API: " + e.getMessage(), e);
        }
    }

    public WeekMeals getWeeklyMeals (@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions) {
        String apiUrl = spoonacularBaseUrl + spoonacularMealPlanUrl;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("timeFrame" , "day")
                .queryParam("targetCalories" , numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude" , exclusions)
                .queryParam("apiKey", apiKey);

        String finalUrl = uriComponentsBuilder.toUriString();

        try {
            ResponseEntity<WeekMeals> response = restTemplate.getForEntity(finalUrl, WeekMeals.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to fetch daily meals: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Error calling Spoonacular API: " + e.getMessage(), e);
        }
    }
}
