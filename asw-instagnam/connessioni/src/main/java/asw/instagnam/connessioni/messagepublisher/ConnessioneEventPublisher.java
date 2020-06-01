package asw.instagnam.connessioni.messagepublisher;

import asw.instagnam.common.api.event.DomainEvent;

public interface ConnessioneEventPublisher {
	
	public void publish(DomainEvent event);
	
}
