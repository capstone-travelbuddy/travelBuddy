package com.capstone.travelbuddy.model;

import javax.persistence.*;

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

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
