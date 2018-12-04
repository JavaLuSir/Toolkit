package design_model.observer;

/**
 * invoke observer design model
 * @author JavaLuSir
 *
 */
public class Client {

	public static void main(String[] args) {
		MySubject sub = new MySubject();
		IObserver obs = new ObserverA();
		IObserver obss = new ObserverB();
		sub.attach(obs);
		sub.attach(obss);
		sub.change("new State");
		sub.change("changed State");
		
	}
}
