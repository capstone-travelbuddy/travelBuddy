package com.capstone.travelbuddy.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private int rating;

	@Column(nullable = false)
	private LocalDate created;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Review{" +
				"id=" + id +
				", description='" + description + '\'' +
				", rating=" + rating +
				", created=" + created +
				", user=" + user +
				", shop=" + shop +
				'}';
	}
}
