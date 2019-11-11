package br.edu.utfpr.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ticket_request")
public class TicketRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	@Column(name="donation_amount")
	private long donationAmount;
	
	@ManyToOne
	@JoinColumn(name="shw_id", referencedColumnName = "id")
	private Show show;
	
	@ManyToOne
	@JoinColumn(name="usr_id", referencedColumnName = "id")
	private User user;
	

	public TicketRequest(Long id, int quantity, long donationAmount, Show show, User user) {
		this.id = id;
		this.quantity = quantity;
		this.donationAmount = donationAmount;
		this.show = show;
		this.user = user;
	}
	
	public TicketRequest() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(long donationAmount) {
		this.donationAmount = donationAmount;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
