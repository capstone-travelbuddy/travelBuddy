package com.capstone.travelbuddy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shops")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String address;

	private String phoneNumber;

	@Column(nullable = false, length = 512)
	private String description;

	@OneToOne
	private Image shopImage;

	@OneToOne
	private Category category;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToMany(mappedBy = "likedShops")
	private Set<User> likes;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getShopImage() {
		return shopImage;
	}

	public void setShopImage(Image shopImage) {
		this.shopImage = shopImage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}
}
