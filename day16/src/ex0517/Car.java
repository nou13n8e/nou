package ex0517;

public class Car {
	int gas;
	
	void setGas(int gas) {
		this.gas=gas;
	}
	
	boolean isGas() {
		if(gas==0) {
			System.out.println("가스가 없습니다.");
			gas-=1;
			return false;
		}
		System.out.println("가스가 있습니다.");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas>0) {
				System.out.println("자동차가 달립니다."+"gas량 : "+gas);
				gas-=1;
			}else {
				System.out.println("자동차가 멈춥니다."+"gas량 : "+gas);
				return; //여기에서 메서드 종료!
			}
		}
	}
}
