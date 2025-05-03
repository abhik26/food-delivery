import { FoodItem } from "./food-item";
import { Restaurant } from "./restaurant";

export interface Order {
	foodItems: FoodItem[];
	restaurant: Restaurant;
	userId: number;
}
