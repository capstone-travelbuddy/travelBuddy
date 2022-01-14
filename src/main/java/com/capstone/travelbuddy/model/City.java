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

	@Column(nullable = false)
	private int zipcode;

	@OneToOne
	private Image cityImage;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
	private List<Shop> shops;
}
