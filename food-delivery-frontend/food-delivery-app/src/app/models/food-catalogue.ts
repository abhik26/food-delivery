import { FoodItem } from "./food-item";
import { Restaurant } from "./restaurant";

export interface FoodCatalogue {
	foodItems: FoodItem[];
	restaurant: Restaurant;
}
