package com.javatrainee.batch27.entity;

import java.math.BigDecimal;


public class Saham{

	private long idsaham;

	private String deskripsi;

	private String kodeSaham;

	private BigDecimal lastprice;

	private String nama;

	public long getIdsaham() {
		return this.idsaham;
	}

	public void setIdsaham(long idsaham) {
		this.idsaham = idsaham;
	}

	public String getDeskripsi() {
		return this.deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getKodeSaham() {
		return this.kodeSaham;
	}

	public void setKodeSaham(String kodeSaham) {
		this.kodeSaham = kodeSaham;
	}

	public BigDecimal getLastprice() {
		return this.lastprice;
	}

	public void setLastprice(BigDecimal lastprice) {
		this.lastprice = lastprice;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}


}