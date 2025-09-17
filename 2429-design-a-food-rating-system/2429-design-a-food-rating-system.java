import java.util.*;

class FoodRatings {

    // Maps food -> cuisine
    private Map<String, String> foodToCuisine;
    // Maps food -> rating
    private Map<String, Integer> foodToRating;
    // Maps cuisine -> ordered set of foods (sorted by rating desc, then name asc)
    private Map<String, TreeSet<Food>> cuisineToFoods;

    // Custom Food class
    private static class Food implements Comparable<Food> {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food other) {
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating); // higher rating first
            }
            return this.name.compareTo(other.name); // lexicographically smaller first
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Food)) return false;
            Food other = (Food) obj;
            return this.name.equals(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>());
            cuisineToFoods.get(cuisine).add(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        // Remove old record
        cuisineToFoods.get(cuisine).remove(new Food(food, oldRating));

        // Update rating
        foodToRating.put(food, newRating);

        // Add new record
        cuisineToFoods.get(cuisine).add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }
}
