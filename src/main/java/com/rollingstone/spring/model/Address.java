package com.rollingstone.spring.model;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SqlResultSetMapping(name = "addressPartialMapping", classes = {
		@ConstructorResult(targetClass = AddressDTO.class, columns  = {
				@ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "house_number"),
				@ColumnResult(name = "street_address"),
				@ColumnResult(name = "city"),
				@ColumnResult(name = "state"),
				@ColumnResult(name = "zip_code"),
				@ColumnResult(name = "account_id", type = Long.class)
		})
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "AddressDaoRepository.getAddressByID",
			query = "SELECT id,city,house_number,state, street_address, zip_code, "
			+ "account_id FROM rollingstone_address a WHERE a.id = :id", resultSetMapping = "addressPartialMapping" )
})
@Entity
@Table(name = "ROLLINGSTONE_ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="house_number", nullable = false)
	private String houseNumber;
	
	@Column(name="street_address", nullable = false)
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	@Column(name="zip_code", nullable = false)
	private String zipCode;

	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name  = "ACCOUNT_ID", nullable = false)
	private Account account;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

	public Address(long id, String houseNumber, String streetAddress, String city, String state, String zipCode,
			Account account) {
		super();
		this.id = id;
		this.houseNumber = houseNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.account = account;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNumber=" + houseNumber + ", streetAddress=" + streetAddress + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Address other = (Address) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (houseNumber == null) {
			if (other.houseNumber != null)
				return false;
		} else if (!houseNumber.equals(other.houseNumber))
			return false;
		if (id != other.id)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	
	
}
