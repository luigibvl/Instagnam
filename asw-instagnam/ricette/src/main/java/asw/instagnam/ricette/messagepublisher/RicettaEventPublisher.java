package asw.instagnam.ricette.messagepublisher;

import asw.instagnam.common.api.event.DomainEvent;

public interface RicettaEventPublisher {
	
	public void publish(DomainEvent event);

}
