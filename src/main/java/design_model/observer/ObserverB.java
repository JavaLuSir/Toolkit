package design_model.observer;
/**
 * implements Observer
 * @author JavaLuSir
 *
 */
public class ObserverB implements IObserver{

	private String state;
	@Override
	public void update(String newState) {
		state = newState;
		System.out.println("B主题状态为:"+state);
	}

}
