package design_model.mediator;

public class Worker extends Colleague{

	public Worker(AbstractMediator mediator) {
		super(mediator);
	}

	@Override
	public void receivedMessage(String msg) {
		System.out.println("woker has got the message -'" + msg + "'");
	}

	@Override
	public void sendMessage() {
		System.out.println("worker has send the message -'" + this.getMessage() + "'");
		
	}
	
	

}
