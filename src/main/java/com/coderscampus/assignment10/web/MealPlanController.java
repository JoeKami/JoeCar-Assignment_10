package com.coderscampus.assignment10.web;

import com.coderscampus.assignment10.domain.DayResponse;
import com.coderscampus.assignment10.domain.WeekResponse;
import com.coderscampus.assignment10.service.MealPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealPlanController {

    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping("/week")
    public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions) {
        WeekResponse weekResponse = mealPlanService.getWeeklyMeals(numCalories, diet, exclusions);
        return ResponseEntity.ok(weekResponse);
    }

    @GetMapping("/day")
    public ResponseEntity<DayResponse> getDayMeals(@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions) {
        DayResponse dayResponse = mealPlanService.getDailyMeals(numCalories, diet, exclusions);
        return ResponseEntity.ok(dayResponse);
    }
}
