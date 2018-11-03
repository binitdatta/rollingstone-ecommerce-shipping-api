package com.rollingstone.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ROLLINGSTONE_SHIPPING")
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="OFFER_ID", nullable = false)
	private Long offerId;
	
	@Column(name ="IS_AVAILABLE", nullable = false)
	private boolean isAvailable;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="ARRIVAL_DATE", nullable = false, unique = false, length = 10)
	private Date arrivalDate;
	
	@Column(name ="IS_FREE", nullable = false)
	private boolean isFree;
	
	@Column(name ="DAYS-IN_TRANSIT", nullable = false)
	private int daysInTransit;
	
	@Column(name ="SHIPPING_CHARGE", nullable = false)
	private Double shippingCharge;
	
	@Column(name ="IS_FREE_FOR_MEMBERS", nullable = false)
	private boolean isFreeForMembers;
	
	@Column(name ="SHIPPING_MODE", nullable = false)
	private String shippingMode;
	
	@Column(name ="SHIPPING_CARRIER", nullable = false)
	private String shipCarrier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	private Order order;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment", cascade = CascadeType.ALL)
	private Set<ShippingLineItem> shippingItems = new HashSet<ShippingLineItem>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public int getDaysInTransit() {
		return daysInTransit;
	}

	public void setDaysInTransit(int daysInTransit) {
		this.daysInTransit = daysInTransit;
	}

	public Double getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(Double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public boolean isFreeForMembers() {
		return isFreeForMembers;
	}

	public void setFreeForMembers(boolean isFreeForMembers) {
		this.isFreeForMembers = isFreeForMembers;
	}

	public String getShippingMode() {
		return shippingMode;
	}

	public void setShippingMode(String shippingMode) {
		this.shippingMode = shippingMode;
	}

	public String getShipCarrier() {
		return shipCarrier;
	}

	public void setShipCarrier(String shipCarrier) {
		this.shipCarrier = shipCarrier;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<ShippingLineItem> getShippingItems() {
		return shippingItems;
	}

	public void setShippingItems(Set<ShippingLineItem> shippingItems) {
		this.shippingItems = shippingItems;
	}

	public Shipping(long id, Long offerId, boolean isAvailable, Date arrivalDate, boolean isFree, int daysInTransit,
			Double shippingCharge, boolean isFreeForMembers, String shippingMode, String shipCarrier, Order order,
			Set<ShippingLineItem> shippingItems) {
		super();
		this.id = id;
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.arrivalDate = arrivalDate;
		this.isFree = isFree;
		this.daysInTransit = daysInTransit;
		this.shippingCharge = shippingCharge;
		this.isFreeForMembers = isFreeForMembers;
		this.shippingMode = shippingMode;
		this.shipCarrier = shipCarrier;
		this.order = order;
		this.shippingItems = shippingItems;
	}

	public Shipping() {
		super();
	}

	@Override
	public String toString() {
		return "Shipping [id=" + id + ", offerId=" + offerId + ", isAvailable=" + isAvailable + ", arrivalDate="
				+ arrivalDate + ", isFree=" + isFree + ", daysInTransit=" + daysInTransit + ", shippingCharge="
				+ shippingCharge + ", isFreeForMembers=" + isFreeForMembers + ", shippingMode=" + shippingMode
				+ ", shipCarrier=" + shipCarrier + ", order=" + order + ", shippingItems=" + shippingItems + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + daysInTransit;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + (isFree ? 1231 : 1237);
		result = prime * result + (isFreeForMembers ? 1231 : 1237);
		result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((shipCarrier == null) ? 0 : shipCarrier.hashCode());
		result = prime * result + ((shippingCharge == null) ? 0 : shippingCharge.hashCode());
		result = prime * result + ((shippingItems == null) ? 0 : shippingItems.hashCode());
		result = prime * result + ((shippingMode == null) ? 0 : shippingMode.hashCode());
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
		Shipping other = (Shipping) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (daysInTransit != other.daysInTransit)
			return false;
		if (id != other.id)
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (isFree != other.isFree)
			return false;
		if (isFreeForMembers != other.isFreeForMembers)
			return false;
		if (offerId == null) {
			if (other.offerId != null)
				return false;
		} else if (!offerId.equals(other.offerId))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (shipCarrier == null) {
			if (other.shipCarrier != null)
				return false;
		} else if (!shipCarrier.equals(other.shipCarrier))
			return false;
		if (shippingCharge == null) {
			if (other.shippingCharge != null)
				return false;
		} else if (!shippingCharge.equals(other.shippingCharge))
			return false;
		if (shippingItems == null) {
			if (other.shippingItems != null)
				return false;
		} else if (!shippingItems.equals(other.shippingItems))
			return false;
		if (shippingMode == null) {
			if (other.shippingMode != null)
				return false;
		} else if (!shippingMode.equals(other.shippingMode))
			return false;
		return true;
	}
	
	
}
