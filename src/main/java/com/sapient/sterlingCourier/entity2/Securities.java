package com.sapient.sterlingCourier.entity2;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
/*@NamedQueries(value = {
		@NamedQuery(name = "Securities.fetchAll",query = "SELECT s from Securities s")
})*/
public class Securities {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID",updatable = false)
	private int id;
	@Column(name="SYMBOL")
	private String symbol;
	@Column(name="NAME")
	private String name;
	@Column(name="MARKET_PRICE")
	private BigDecimal market_price;
	@Column(name="VOLUME")
	private BigInteger volume;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMarketPrice() {
		return market_price;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.market_price = marketPrice;
	}

	public BigInteger getVolume() {
		return volume;
	}

	public void setVolume(BigInteger volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Securities [symbol=" + symbol + ", name=" + name
				+ ", marketPrice=" + market_price + ", volume=" + volume + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((market_price == null) ? 0 : market_price.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Securities other = (Securities) obj;
		if (market_price == null) {
			if (other.market_price != null)
				return false;
		} else if (!market_price.equals(other.market_price))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

}
