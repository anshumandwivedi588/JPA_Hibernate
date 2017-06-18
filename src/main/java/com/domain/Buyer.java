package com.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Buyer")
@Table(name = "buyer")
public class Buyer implements Serializable {
    
    /**
     * One buyer (OneToMany) multiple Purchase orders (ManyToOne)
     */
    private static final long serialVersionUID = 1443945058331501540L;
    // org.hibernate.dialect.Oracle10gDialect does not support IDENTITY key generation
    @Id
    @Column(name = "buyer_id")
    private Long buyerId;
    
    @Column(name = "buyer_name")
    private String buyerName;
    
    @Column(name = "gender")
    private Character gender;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "city")
    private String city;
    
    @OneToMany(mappedBy = "buyer_id", cascade = CascadeType.ALL)
    private Set<PurchaseOrder> purchaseOrders;

    public Set<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * mappedBy must be same as primary key column name of Buyer
     */
}
