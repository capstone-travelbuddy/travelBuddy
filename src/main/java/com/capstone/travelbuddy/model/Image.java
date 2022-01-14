package com.capstone.travelbuddy.model;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String path;

	@ManyToOne
	@JoinColumn(name = "review_id")
	private Review review;
}
