package com.coderscampus.assignment10.web;

import com.coderscampus.assignment10.domain.DayMeals;
import com.coderscampus.assignment10.domain.WeekMeals;
import com.coderscampus.assignment10.service.MealPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mealplanner")
public class MealPlanController {

    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekMeals> getWeekMeals(@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions) {
        WeekMeals weekMeals = mealPlanService.getWeeklyMeals(numCalories, diet, exclusions);
        return ResponseEntity.ok(weekMeals);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayMeals> getDayMeals(@RequestParam String numCalories, @RequestParam String diet, @RequestParam String exclusions) {
        DayMeals dayMeals = mealPlanService.getDailyMeals(numCalories, diet, exclusions);
        return ResponseEntity.ok(dayMeals);
    }
}
