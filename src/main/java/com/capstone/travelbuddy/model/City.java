package com.capstone.travelbuddy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false, length = 512)
	private String description;

	@OneToOne
	private Image cityImage;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
	private List<Shop> shops;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getCityImage() {
		return cityImage;
	}

	public void setCityImage(Image cityImage) {
		this.cityImage = cityImage;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
}
