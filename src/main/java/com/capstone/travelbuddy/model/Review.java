package com.capstone.travelbuddy.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
	private Date created;

	@OneToOne
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
	private List<Image> images;
}
