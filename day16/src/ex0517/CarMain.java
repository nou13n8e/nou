package ex0517;

public class CarMain {
	public static void main(String[] args) {
		Car car=new Car();
		
		car.setGas(5);
		
		if(car.isGas()) {
			System.out.println("출발!");
			
			car.run();
		}
		System.out.println("가스를 넣어주세요.");
	}
}
