package com.felipe.DsListGamer.dto;

import java.io.Serializable;

import com.felipe.DsListGamer.entities.Game;

public class GameDtoMin implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;

	public GameDtoMin() {
	}

	public GameDtoMin(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

}
