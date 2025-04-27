import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
	providedIn: 'root'
})
export class RestaurantService {

	private restaurantsApiUrl: String = environment.restaurantsApiUrl;

	constructor(private httpClient: HttpClient) { }

	getAllRestaurants(): Observable<any> {
		return this.httpClient.get<any>(`${this.restaurantsApiUrl}`);
	}
}
