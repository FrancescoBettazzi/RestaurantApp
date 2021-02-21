package com.restaurantapp.businesslogic;
import java.util.ArrayList;

import java.util.Observable;

import com.restaurantapp.domainmodel.KindOfDish;
import com.restaurantapp.domainmodel.Order;
import com.restaurantapp.domainmodel.OrderRecord;

//Interfaccia aperta direttamente senza login se si clicca sul pulsante Bar

public class BarController extends OrderPageController{
	
	public BarController(Observable obs, String id) {
		this.id=id;
		obs.addObserver(this);
		orderRecords = new ArrayList<OrderRecord>();
	}
	
	@Override
	public void getOrder(Order order) {
		for(OrderRecord ord : order.getRecords()) {
			if(ord.getDish().getKindOfDish() == KindOfDish.DESSERT ||
			   ord.getDish().getKindOfDish() == KindOfDish.DRINK) {
				orderRecords.add(ord);
			}
		}
	}
}

