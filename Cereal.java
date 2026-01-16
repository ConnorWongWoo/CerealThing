import java.util.*;
import java.io.*;
import java.lang.Math;

public class Cereal {
        private String name;
        private String type;
        private double calories;
        private double protein; 
        private double fat;
        private double sodium;
        private double fiber;
        private double carbohydrates;
        private double sugar;
        private double potassium;
        private double vitamins;
        private double shelf;
        private double weight;
        private double cups;
        private double rating;
        
        public Cereal(String name, String type, double cal, double protein, double fat, double sodium, double fiber, double carb, 
                      double sugar, double potassium, double vitamins, double shelf, double weight, double cups, double rating) {
            this.name = name;
            this.type = type;
            this.calories = cal;
            this.protein = protein;
            this.fat = fat;
            this.sodium = sodium;
            this.fiber = fiber;
            this.carbohydrates = carb;
            this.sugar = sugar;
            this.potassium = potassium;
            this.vitamins = vitamins;
            this.shelf = shelf;
            this.weight = weight;
            this.cups = cups;
            this.rating = rating;
        }
        public String toString() {
            return String.format("Cereal: %s\nCalories: %f\nProtein: %f\nFat: %f\nSodium: %f\nFiber: %f\nCarbs: %f\nSugar: %f\nPotassium: %f\nVitamins: %f\nShelf: %f\nWeight: %f\nCups: %f\nRating: %f",
                this.name, this.calories, this.protein, this.fat, this.sodium, this.fiber, this.carbohydrates, this.sugar, this.potassium, this.vitamins, this.shelf, this.weight, this.cups, this.rating);
        }
        /** @brief Returns the nutrition rating using a custom nutrition rating formula
         * Example: 100% Bran | 70 cal | 4 protein | 1 fat | 130 sodium | 10 fiber | 5 carb | 6 sugar | 280 potassium | 25 vitamin
         * Rating = 3.415
         */
        public double getNutritionRating() {
            double rating = (this.protein * 1 + this.fiber * 1 - this.fat * 0.5 - this.sugar * 1 * (this.potassium-this.sodium) + 0.1 * this.vitamins) * (this.protein + this.fiber)/this.calories;
            // return 10 * (rating + 176.8) / (65 + 176.8);
            return -Math.round(rating);
        }
        public String getName() {
            return this.name;
        }
}