package com.rollingstone.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tomcat.jni.Address;

@Entity
@Table(name = "ROLLINGSTONE_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="ORDER_NUMBER", nullable = false)
	private String orderNumber;
	
	@Column(name ="ORDER_TRACKING_NUMBER", nullable = false)
	private String orderTrackingNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="ORDER_DATE", nullable = false, unique = false, length = 10)
	private Date orderDate;
	
	@Column(name ="ORDER_TOTAL", nullable = false)
	private Double orderTotal;
	
	@OneToOne
	@JoinColumn(name = "USER_PROFILE_ID")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "SHIPPING_ADDRESS_ID")
	private Address shippingAddress;
	
	@OneToOne
	@JoinColumn(name = "BILLING_ADDRESS_ID")
	private Address billingAddress;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private Set<OrderLineItem> orderItems  = new HashSet<OrderLineItem>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	public Order(long id, String orderNumber, String orderTrackingNumber, Date orderDate, Double orderTotal, User user,
			Address shippingAddress, Address billingAddress, Account account, Set<OrderLineItem> orderItems) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderTrackingNumber = orderTrackingNumber;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.user = user;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.account = account;
		this.orderItems = orderItems;
	}

	public Set<OrderLineItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderLineItem> orderItems) {
		this.orderItems = orderItems;
	}

	

	public Order() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((billingAddress == null) ? 0 : billingAddress.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((orderTotal == null) ? 0 : orderTotal.hashCode());
		result = prime * result + ((orderTrackingNumber == null) ? 0 : orderTrackingNumber.hashCode());
		result = prime * result + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (billingAddress == null) {
			if (other.billingAddress != null)
				return false;
		} else if (!billingAddress.equals(other.billingAddress))
			return false;
		if (id != other.id)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderItems == null) {
			if (other.orderItems != null)
				return false;
		} else if (!orderItems.equals(other.orderItems))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (orderTotal == null) {
			if (other.orderTotal != null)
				return false;
		} else if (!orderTotal.equals(other.orderTotal))
			return false;
		if (orderTrackingNumber == null) {
			if (other.orderTrackingNumber != null)
				return false;
		} else if (!orderTrackingNumber.equals(other.orderTrackingNumber))
			return false;
		if (shippingAddress == null) {
			if (other.shippingAddress != null)
				return false;
		} else if (!shippingAddress.equals(other.shippingAddress))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderTrackingNumber=" + orderTrackingNumber
				+ ", orderDate=" + orderDate + ", orderTotal=" + orderTotal + ", user=" + user + ", shippingAddress="
				+ shippingAddress + ", billingAddress=" + billingAddress + ", account=" + account + ", orderItems="
				+ orderItems + "]";
	}

	
	
	
	
}
