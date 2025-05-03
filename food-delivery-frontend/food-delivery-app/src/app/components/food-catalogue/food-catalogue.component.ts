import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodItem } from 'src/app/models/food-item';
import { FoodCatalogueService } from 'src/app/services/food-catalogue.service';

@Component({
	selector: 'app-food-catalogue',
	templateUrl: './food-catalogue.component.html',
	styleUrls: ['./food-catalogue.component.css']
})
export class FoodCatalogueComponent implements OnInit {

	restaurantId?: number;
	foodCatalogue: any;
	foodItemCart: FoodItem[] = [];
	orderSummary: {};

	constructor(private route: ActivatedRoute, private router: Router, private foodCatalogueService: FoodCatalogueService) { }

	ngOnInit(): void {
		this.route.paramMap.subscribe(params => {
			this.restaurantId = + params.get('id');
		});

		this.getFoodCatalogueByRestaurant(this.restaurantId);
	}

	getFoodCatalogueByRestaurant(restaurantId: number) {
		this.foodCatalogueService.getFoodCatalogueByRestaurant(restaurantId).subscribe(data => {
			this.foodCatalogue = data;
		});
	}

	increment(foodItem: FoodItem) {
		foodItem.quantity++;

		const itemIndex = this.foodItemCart.findIndex(item => item.id === foodItem.id);

		if (itemIndex < 0) {
			this.foodItemCart.push(foodItem);
		}
	}

	decrement(foodItem: FoodItem) {
		if (foodItem.quantity > 0) {
			foodItem.quantity--;
		}

		const itemIndex = this.foodItemCart.findIndex(item => item.id === foodItem.id);

		if (foodItem.quantity == 0) {
			this.foodItemCart.splice(itemIndex, 1);
		}
	}

	onCheckOut() {
		this.orderSummary = {
			foodItems: this.foodItemCart,
			restaurant: this.foodCatalogue.restaurant
		}

		this.router.navigate(['/order-summary'], { queryParams: { data: JSON.stringify(this.orderSummary) } });
	}

}
