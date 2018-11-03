package com.rollingstone.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLINGSTONE_ORDER_ITEMS")
public class OrderLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="PRODUCT_ID", nullable = false)
	private Long productId;
	
	@Column(name ="QTY_ORDERED", nullable = false)
	private int quantityOrdered;
	
	@Column(name ="UNIT_PRICE", nullable = false)
	private Double unitPrice;
	
	@Column(name ="UOM", nullable = false)
	private String uom;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	Order order;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderLineItem(long id, Long productId, int quantityOrdered, Double unitPrice, String uom, Order order) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantityOrdered = quantityOrdered;
		this.unitPrice = unitPrice;
		this.uom = uom;
		this.order = order;
	}

	
	public OrderLineItem() {
		super();
	}

	@Override
	public String toString() {
		return "OrderLineItem [id=" + id + ", productId=" + productId + ", quantityOrdered=" + quantityOrdered
				+ ", unitPrice=" + unitPrice + ", uom=" + uom + ", order=" + order + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + quantityOrdered;
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLineItem other = (OrderLineItem) obj;
		if (id != other.id)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantityOrdered != other.quantityOrdered)
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		return true;
	}


	
	
}
