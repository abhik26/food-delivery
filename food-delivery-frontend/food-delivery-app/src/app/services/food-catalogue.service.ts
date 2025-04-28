import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
	providedIn: 'root'
})
export class FoodCatalogueService {

	private foodCataloguesApiUrl: String = environment.foodCataloguesApiUrl;

	constructor(private http: HttpClient) { }

	getFoodCatalogueByRestaurant(restaurantId: number): Observable<any> {
		return this.http.get<any>(`${this.foodCataloguesApiUrl}/${restaurantId}`);
	}
}
