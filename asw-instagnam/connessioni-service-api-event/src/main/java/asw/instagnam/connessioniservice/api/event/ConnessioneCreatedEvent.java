package asw.instagnam.connessioniservice.api.event;

import asw.instagnam.common.api.event.DomainEvent; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//evento da pubblicare

@Data
@NoArgsConstructor
public class ConnessioneCreatedEvent implements DomainEvent{

	private String follower; 
	private String followed; 
	
	public ConnessioneCreatedEvent(String follower, String followed) {
		this.follower = follower; 
		this.followed = followed; 
	}


	public String getFollower() {
		return follower;
	}

	public void setFollower(String follower) {
		this.follower = follower;
	}

	public String getFollowed() {
		return followed;
	}

	public void setFollowed(String followed) {
		this.followed = followed;
	}
	
}

