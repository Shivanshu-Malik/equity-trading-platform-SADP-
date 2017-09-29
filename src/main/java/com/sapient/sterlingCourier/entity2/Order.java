package com.sapient.sterlingCourier.entity2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Orders")
/*@NamedQueries(value = {
		@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o where o.status not like 'DELETED'"),
		@NamedQuery(name = "Order.findBySide", query = "SELECT o FROM Order o WHERE o.side =:side AND o.status not like 'DELETED'"),
		@NamedQuery(name = "Order.findBySideBySymbol", query = "SELECT o FROM Order o WHERE o.side =:side and o.symbol=:symbol AND o.status not like 'DELETED'"),
		@NamedQuery(name = "Order.findBySymbol", query = "SELECT o FROM Order o WHERE o.symbol =:symbol AND o.status not like 'DELETED'"),
		@NamedQuery(name = "Order.delete", query = "UPDATE Order o SET o.status='DELETED' WHERE o.orderId = :id"),

		@NamedQuery(name = "Order.changeStatus", query = "UPDATE Order o SET o.status='OPEN' WHERE o.orderId = :id") })

		@NamedQuery(name="Order.findAll",query="SELECT o FROM Order o where o.status =:status and o.blockId=:blockId"),
		@NamedQuery(name = "Order.OrdersInBlock", query = "SELECT o FROM Order o WHERE o.blockId =:blockId"),
		*/

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private String side;
	private String symbol;
	private BigInteger portfolioId;

	private BigInteger totalQuantity;
	private BigInteger allocatedQuantity;
	private String orderType;
	private BigDecimal limitPrice;
	private BigDecimal stopPrice;
	private BigDecimal executedPrice;
	private BigInteger traderId;
	private String status;
	private BigInteger clientId;
	private String accountType;
	private String notes;
	private BigInteger blockId;
	private Timestamp creationTime;

	public Order() {

	}
	public Order(Long orderId, String side, String symbol,
			BigInteger portfolioId, BigInteger totalQuantity,
			BigInteger allocatedQuantity, String orderType,
			BigDecimal limitPrice, BigDecimal stopPrice,
			BigDecimal executedPrice, BigInteger traderId, String status,
			BigInteger clientId, String accountType, String notes,
			BigInteger blockId, Timestamp creationTime) {
		super();
		this.orderId = orderId;
		this.side = side;
		this.symbol = symbol;
		this.portfolioId = portfolioId;
		this.totalQuantity = totalQuantity;
		this.allocatedQuantity = allocatedQuantity;
		this.orderType = orderType;
		this.limitPrice = limitPrice;
		this.stopPrice = stopPrice;
		this.executedPrice = executedPrice;
		this.traderId = traderId;
		this.status = status;
		this.clientId = clientId;
		this.accountType = accountType;
		this.notes = notes;
		this.blockId = blockId;
		this.creationTime = creationTime;
	}
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigInteger getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(BigInteger portfolioId) {
		this.portfolioId = portfolioId;
	}

	public BigInteger getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(BigInteger totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public BigInteger getAllocatedQuantity() {
		return allocatedQuantity;
	}

	public void setAllocatedQuantity(BigInteger allocatedQuantity) {
		this.allocatedQuantity = allocatedQuantity;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(BigDecimal limitPrice) {
		this.limitPrice = limitPrice;
	}

	public BigDecimal getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(BigDecimal stopPrice) {
		this.stopPrice = stopPrice;
	}

	public BigDecimal getExecutedPrice() {
		return executedPrice;
	}

	public void setExecutedPrice(BigDecimal executedPrice) {
		this.executedPrice = executedPrice;
	}

	public BigInteger getTraderId() {
		return traderId;
	}

	public void setTraderId(BigInteger traderId) {
		this.traderId = traderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigInteger getClientId() {
		return clientId;
	}

	public void setClientId(BigInteger clientId) {
		this.clientId = clientId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigInteger getBlockId() {
		return blockId;
	}

	public void setBlockId(BigInteger blockId) {
		this.blockId = blockId;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	

	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", side=" + side + ", symbol="
				+ symbol + ", portfolioId=" + portfolioId + ", totalQuantity="
				+ totalQuantity + ", allocatedQuantity=" + allocatedQuantity
				+ ", orderType=" + orderType + ", limitPrice=" + limitPrice
				+ ", stopPrice=" + stopPrice + ", executedPrice="
				+ executedPrice + ", traderId=" + traderId + ", status="
				+ status + ", clientId=" + clientId + ", accountType="
				+ accountType + ", notes=" + notes + ", blockId=" + blockId
				+ ", creationTime=" + creationTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		result = prime
				* result
				+ ((allocatedQuantity == null) ? 0 : allocatedQuantity
						.hashCode());
		result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
		result = prime * result
				+ ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result
				+ ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result
				+ ((executedPrice == null) ? 0 : executedPrice.hashCode());
		result = prime * result
				+ ((limitPrice == null) ? 0 : limitPrice.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((orderType == null) ? 0 : orderType.hashCode());
		result = prime * result
				+ ((portfolioId == null) ? 0 : portfolioId.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((stopPrice == null) ? 0 : stopPrice.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result
				+ ((totalQuantity == null) ? 0 : totalQuantity.hashCode());
		result = prime * result
				+ ((traderId == null) ? 0 : traderId.hashCode());
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
		Order other = (Order) obj;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (allocatedQuantity == null) {
			if (other.allocatedQuantity != null)
				return false;
		} else if (!allocatedQuantity.equals(other.allocatedQuantity))
			return false;
		if (blockId == null) {
			if (other.blockId != null)
				return false;
		} else if (!blockId.equals(other.blockId))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (executedPrice == null) {
			if (other.executedPrice != null)
				return false;
		} else if (!executedPrice.equals(other.executedPrice))
			return false;
		if (limitPrice == null) {
			if (other.limitPrice != null)
				return false;
		} else if (!limitPrice.equals(other.limitPrice))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderType == null) {
			if (other.orderType != null)
				return false;
		} else if (!orderType.equals(other.orderType))
			return false;
		if (portfolioId == null) {
			if (other.portfolioId != null)
				return false;
		} else if (!portfolioId.equals(other.portfolioId))
			return false;
		if (side == null) {
			if (other.side != null)
				return false;
		} else if (!side.equals(other.side))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stopPrice == null) {
			if (other.stopPrice != null)
				return false;
		} else if (!stopPrice.equals(other.stopPrice))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (totalQuantity == null) {
			if (other.totalQuantity != null)
				return false;
		} else if (!totalQuantity.equals(other.totalQuantity))
			return false;
		if (traderId == null) {
			if (other.traderId != null)
				return false;
		} else if (!traderId.equals(other.traderId))
			return false;
		return true;
	}

}
