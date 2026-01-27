package javaGenerics;

/*
 * Personalized Meal Plan Generator
 * Concepts: Generic Methods, Type Parameters, Bounded Type Parameters
 * 
 * This program demonstrates a meal plan generator where users can choose different
 * meal categories (Vegetarian, Vegan, Keto, High-Protein) ensuring type safety.
 */

// Interface for MealPlan
interface MealPlan {
    String getMealType();

    void displayDailyPlan();
}

// Concrete Meal Plan Implementations
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public void displayDailyPlan() {
        System.out.println("Breakfast: Oatmeal | Lunch: Grilled Cheese | Dinner: Vegetable Stir-fry");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public void displayDailyPlan() {
        System.out.println("Breakfast: Smoothie | Lunch: Avocado Toast | Dinner: Lentil Soup");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public void displayDailyPlan() {
        System.out.println("Breakfast: Eggs & Bacon | Lunch: Chicken Salad | Dinner: Grilled Salmon");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public void displayDailyPlan() {
        System.out.println("Breakfast: Greek Yogurt | Lunch: Turkey Breast | Dinner: Steak & Veggies");
    }
}

// Generic class to handle meal plans
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

// Main class
public class PersonalizedMealPlan {

    // Generic method to validate and generate a meal plan
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        T plan = meal.getMealPlan();
        System.out.println("Generating " + plan.getMealType() + " Meal Plan...");
        plan.displayDailyPlan();
        System.out.println("Plan generated successfully.\n");
    }

    public static void main(String[] args) {
        // Create different meal plans
        Meal<VegetarianMeal> vegetarian = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());
        Meal<KetoMeal> keto = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> highProtein = new Meal<>(new HighProteinMeal());

        System.out.println("--- Daily Meal Plans ---\n");
        generatePlan(vegetarian);
        generatePlan(vegan);
        generatePlan(keto);
        generatePlan(highProtein);
    }
}
