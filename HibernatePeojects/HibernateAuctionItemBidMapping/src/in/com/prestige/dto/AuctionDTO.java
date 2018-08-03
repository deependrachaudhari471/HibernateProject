package in.com.prestige.dto;

import java.util.Set;

public class AuctionDTO {
	private Integer itemId;
	private String description;
	private Set bids;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getBids() {
		return bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}
}
