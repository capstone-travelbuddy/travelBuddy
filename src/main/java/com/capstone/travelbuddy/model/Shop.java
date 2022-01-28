package com.capstone.travelbuddy.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shops")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	private String address;

	private String phoneNumber;

	private String socialURL;

	private String website;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
	private List<Image> images;

	@OneToOne
	private Category category;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
	private List<Review> reviews;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getSocialURL() {
		return socialURL;
	}

	public void setSocialURL(String socialURL) {
		this.socialURL = socialURL;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}
}
