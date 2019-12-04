package com.franchise.ylcn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="requests")
public class Franchise {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "TCID")
    private String tcId;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "PHONE")
    private String phone;
    
    @Column(name = "EMAIL")
    private String email;
    
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "BIRTHDATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate birthDate;
    
    @Column(name = "BEFOREEXPERIENCE")
    private String beforeExperience;
    
    @Column(name = "PREFERRED")
    private String preferred;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "DISTRICT")
    private String district;
    
    @Column(name = "NEIGHBORHOOD")
    private String neighborhood;
    
    @Column(name = "INVESTMENTAMOUNT")
    private String investmentAmount;
    
    @Column(name = "ADDEDINFO")
    private String addedInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTcId() {
		return tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getBeforeExperience() {
		return beforeExperience;
	}

	public void setBeforeExperience(String beforeExperience) {
		this.beforeExperience = beforeExperience;
	}

	public String getPreferred() {
		return preferred;
	}

	public void setPreferred(String preferred) {
		this.preferred = preferred;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(String investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public String getAddedInfo() {
		return addedInfo;
	}

	public void setAddedInfo(String addedInfo) {
		this.addedInfo = addedInfo;
	}

	@Override
	public String toString() {
		return "Franchise [id=" + id + ", name=" + name + ", tcId=" + tcId + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", birthDate=" + birthDate + ", beforeExperience=" + beforeExperience
				+ ", preferred=" + preferred + ", city=" + city + ", district=" + district + ", neighborhood="
				+ neighborhood + ", investmentAmount=" + investmentAmount + ", addedInfo=" + addedInfo + "]";
	}
    
}
