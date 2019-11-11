package br.edu.utfpr.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="shows")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String band;
	
	@ManyToOne
	private LocalShow localShow;
	
	public Show(Long id, Date date, String band, LocalShow localShow) {
		this.id = id;
		this.date = date;
		this.band = band;
		this.localShow = localShow;
	}
	
	public Show() {	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public LocalShow getLocalShow() {
		return localShow;
	}

	public void setLocalShow(LocalShow localShow) {
		this.localShow = localShow;
	}
	
}
