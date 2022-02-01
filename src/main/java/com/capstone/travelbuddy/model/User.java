package com.capstone.travelbuddy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@OneToOne
	private Image userImage;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Review> reviews;

	@ManyToMany
	@JoinTable(
			name = "liked_shops",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "shop_id"))
	private List<Shop> likedShops;

	@ManyToMany
	@JoinTable(
			name = "shops_toVisit",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "shop_id"))
	private List<Shop> shopsToVisit;

	public User() {

	}

	public User(User copy) {
		id = copy.id; // This line is SUPER important! Many things won't work if it's absent
		email = copy.email;
		username = copy.username;
		password = copy.password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Image getUserImage() {
		return userImage;
	}

	public void setUserImage(Image userImage) {
		this.userImage = userImage;
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

	public List<Shop> getLikedShops() {
		return likedShops;
	}

	public void setLikedShops(List<Shop> likedShops) {
		this.likedShops = likedShops;
	}

	public List<Shop> getShopsToVisit() {
		return shopsToVisit;
	}

	public void setShopsToVisit(List<Shop> shopsToVisit) {
		this.shopsToVisit = shopsToVisit;
	}
}
