import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantListingComponent } from './components/restaurant-listing/restaurant-listing.component';
import { FoodCatalogueComponent } from './components/food-catalogue/food-catalogue.component';

const routes: Routes = [
	{ path: '', component: RestaurantListingComponent, pathMatch: 'full' }
];

@NgModule({
	declarations: [AppComponent, HeaderComponent, RestaurantListingComponent, FoodCatalogueComponent],
	imports: [RouterModule.forRoot(routes), BrowserModule, HttpClientModule],
	providers: [],
	bootstrap: [AppComponent],
})
export class AppModule { }
