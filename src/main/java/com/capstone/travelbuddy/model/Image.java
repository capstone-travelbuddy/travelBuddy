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
	@JoinColumn(name = "shop_id")
	private Shop shop;

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

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String generateBase64Image()
	{
		return Base64.encodeBase64String(this.getContent());
	}
}
