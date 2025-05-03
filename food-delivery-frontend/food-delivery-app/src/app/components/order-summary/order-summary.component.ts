import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivationStart, Router } from '@angular/router';
import { Order } from 'src/app/models/order';
import { OrderService } from 'src/app/services/order.service';

@Component({
	selector: 'app-order-summary',
	templateUrl: './order-summary.component.html',
	styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent implements OnInit {

	orderSummary: Order;
	obj: any;
	total: any;
	showDialog: boolean = false;

	constructor(private route: ActivatedRoute, private router: Router, private orderService: OrderService) { }

	ngOnInit(): void {
		const data = this.route.snapshot.queryParams['data'];
		this.obj = JSON.parse(data);
		this.obj.userId = 1;
		this.orderSummary = this.obj;

		this.total = this.orderSummary.foodItems.reduce((accumulator, currentValue) => {
			return accumulator + (currentValue.quantity * currentValue.price);
		}, 0);
	}

	closeDialog() {
		this.showDialog = false;
		this.router.navigate(['/']);
	}

	saveOrder() {
		this.orderService.saveOrder(this.orderSummary).subscribe((response) => {
			this.showDialog = true;
		})
	}

}
