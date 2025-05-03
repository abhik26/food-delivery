import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
	providedIn: 'root'
})
export class OrderService {

	orderApiUrl: string = environment.orderApiUrl;

	constructor(private http: HttpClient) { }

	saveOrder(data: any): Observable<any> {
		return this.http.post<any>(this.orderApiUrl, data);
	}
}
