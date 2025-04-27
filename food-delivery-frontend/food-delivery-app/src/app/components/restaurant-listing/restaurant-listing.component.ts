import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/models/restaurant';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
	selector: 'app-restaurant-listing',
	templateUrl: './restaurant-listing.component.html',
	styleUrls: ['./restaurant-listing.component.css']
})
export class RestaurantListingComponent implements OnInit {

	restaurants: Restaurant[] = [];
	
	constructor(private router: Router, private restaurantService: RestaurantService) { }
	
	ngOnInit() {
		this.getAllRestaurants();
	}

	getAllRestaurants() {
		this.restaurantService.getAllRestaurants().subscribe(
            data => {
				this.restaurants = data;
			}
		);

		console.log(`restaurantList: ${this.restaurants}`);
	}
	getRandomNumber(min: number, max: number): number {
		return Math.floor(Math.random() * (max - min + 1)) + min;
	}


	getRandomImage(): string {
		const imageCount = 8; // Adjust this number based on the number of images in your asset folder
		const randomIndex = this.getRandomNumber(1, imageCount);
		return `${randomIndex}.jpg`; // Replace with your image filename pattern
	}

	onButtonClick(id: number) {
		this.router.navigate(['/food-catalogue', id]);
	}

}
