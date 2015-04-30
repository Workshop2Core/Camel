package com.javatrainee.batch27.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderHistory{

	private long idorder;

	private Date dateorder;

	private BigDecimal idcounterpart;

	private String jenistransaksi;

	private BigDecimal lot;

	private BigDecimal price;

	private String status;

	private String saham;

	private String user;

	public long getIdorder() {
		return this.idorder;
	}

	public void setIdorder(long idorder) {
		this.idorder = idorder;
	}

	public Date getDateorder() {
		return this.dateorder;
	}

	public void setDateorder(Date dateorder) {
		this.dateorder = dateorder;
	}

	public BigDecimal getIdcounterpart() {
		return this.idcounterpart;
	}

	public void setIdcounterpart(BigDecimal idcounterpart) {
		this.idcounterpart = idcounterpart;
	}

	public String getJenistransaksi() {
		return this.jenistransaksi;
	}

	public void setJenistransaksi(String jenistransaksi) {
		this.jenistransaksi = jenistransaksi;
	}

	public BigDecimal getLot() {
		return this.lot;
	}

	public void setLot(BigDecimal lot) {
		this.lot = lot;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSaham() {
		return this.saham;
	}

	public void setSaham(String saham) {
		this.saham = saham;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}