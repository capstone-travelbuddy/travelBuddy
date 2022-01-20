package com.capstone.travelbuddy.model;

import org.apache.tomcat.util.codec.binary.Base64;
import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 512, nullable = false, unique = true)
	private String name;

	@Lob
	private byte[] content;

	@ManyToOne
	@JoinColumn(name = "review_id")
	private Review review;

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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public String generateBase64Image()
	{
		return Base64.encodeBase64String(this.getContent());
	}
}
