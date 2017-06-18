package com.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "PurchaseOrder")
@Table(name = "purchase_order")
public class PurchaseOrder implements Serializable {

    /**
     * One buyer (OneToMany) multiple Purchase orders (ManyToOne)
     */
    
    private static final long serialVersionUID = 253961476489843517L;

    @Id
    @Column(name = "order_id")
    private Long orderId;
    
    @Column(name = "order_date")
    private Date orderDate;
    
    @Column(name = "order_amount")
    private double orderAmount;
    
    @ManyToOne
    @JoinColumn(name = "buyer_id_ref")//, referencedColumnName = "buyer_id")
    private Buyer buyer_id;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Buyer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Buyer buyer_id) {
        this.buyer_id = buyer_id;
    }
    
    /**
     * referencedColumnName must be same as primary key column name of Buyer
     */
}
