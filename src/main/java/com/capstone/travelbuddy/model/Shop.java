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

	@OneToOne
	private Image shopImage;

	@OneToOne
	private Category category;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToMany(mappedBy = "likedShops")
	private Set<User> likes;

}
