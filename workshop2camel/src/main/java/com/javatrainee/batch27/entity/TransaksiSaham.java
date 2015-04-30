package com.javatrainee.batch27.entity;

import java.math.BigDecimal;

public class TransaksiSaham{

	private long idtransaksi;

	private BigDecimal lot;

	private Saham saham;

	private String user;


	public long getIdtransaksi() {
		return this.idtransaksi;
	}

	public void setIdtransaksi(long idtransaksi) {
		this.idtransaksi = idtransaksi;
	}

	public BigDecimal getLot() {
		return this.lot;
	}

	public void setLot(BigDecimal lot) {
		this.lot = lot;
	}

	public Saham getSaham() {
		return this.saham;
	}

	public void setSaham(Saham saham) {
		this.saham = saham;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}