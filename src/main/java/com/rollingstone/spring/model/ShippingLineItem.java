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
@Table(name = "ROLLINGSTONE_SHIPPING_ITEMS")
public class ShippingLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="PRODUCT_ID", nullable = false)
	private Long productId;
	
	@Column(name ="QTY_SHIPPED", nullable = false)
	private int quantityShipped;
	
	@Column(name ="UNIT_PRICE", nullable = false)
	private Double unitPrice;
	
	@Column(name ="UOM", nullable = false)
	private String uom;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHIPPING_ID", nullable = false)
	Shipping shipment;

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

	public int getQuantityShipped() {
		return quantityShipped;
	}

	public void setQuantityShipped(int quantityShipped) {
		this.quantityShipped = quantityShipped;
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

	public Shipping getShipment() {
		return shipment;
	}

	public void setShipment(Shipping shipment) {
		this.shipment = shipment;
	}

	public ShippingLineItem(long id, Long productId, int quantityShipped, Double unitPrice, String uom,
			Shipping shipment) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantityShipped = quantityShipped;
		this.unitPrice = unitPrice;
		this.uom = uom;
		this.shipment = shipment;
	}

	@Override
	public String toString() {
		return "ShippingLineItem [id=" + id + ", productId=" + productId + ", quantityShipped=" + quantityShipped
				+ ", unitPrice=" + unitPrice + ", uom=" + uom + ", shipment=" + shipment + "]";
	}

	public ShippingLineItem() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + quantityShipped;
		result = prime * result + ((shipment == null) ? 0 : shipment.hashCode());
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
		ShippingLineItem other = (ShippingLineItem) obj;
		if (id != other.id)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantityShipped != other.quantityShipped)
			return false;
		if (shipment == null) {
			if (other.shipment != null)
				return false;
		} else if (!shipment.equals(other.shipment))
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
