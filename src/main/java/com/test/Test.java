package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.domain.Buyer;
import com.domain.PurchaseOrder;
import com.factories.PersistenceManager;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        PersistenceManager manager = new PersistenceManager();
    }
    
    private void getAll(PersistenceManager manager) {
    	List<Buyer> buyers = manager.getAllBuyers();
        System.out.println(buyers.size());
        for (Buyer buyer : buyers) {
			List<PurchaseOrder> orders = new ArrayList<PurchaseOrder>(buyer.getPurchaseOrders());
			PurchaseOrder order = orders.get(0);
			System.out.println("Buyer "+order.getBuyer_id().getBuyerName()+" has got orderId "+order.getOrderId() +" of amount "+order.getOrderAmount() 
					+" on date "+order.getOrderDate());
		}
    }
    
    private void saveObject(PersistenceManager manager) {
    	manager.persistObject(getBuyer());
        manager.persistObject(getPurchaseOrder());
    }

    private Buyer getBuyer() {
        Buyer buyer = new Buyer();
        buyer.setBuyerId(100L);
        buyer.setAge(26);
        buyer.setBuyerName("Anshuman");
        buyer.setCity("PUNE");
        buyer.setGender('M');
        return buyer;
    }
    
    private PurchaseOrder getPurchaseOrder() {
    	PurchaseOrder order = new PurchaseOrder();
    	Buyer buyer = new Buyer();
        buyer.setBuyerId(100L);
    	order.setBuyer_id(buyer);
    	order.setOrderAmount(1000.00);
    	order.setOrderDate(new Date(System.currentTimeMillis()));
    	order.setOrderId(200L);
    	return order;
    }
}
