package ifEx;

public class IfEx05 {	//else-if
	public static void main(String[] args) {
		int a=6;
		if(a>100) {
			System.out.println("if true");			//실행하지 않음
		}else if(a>50) {
			System.out.println("else if1 ture");	//실행하지 않음
		}else if(a>20) {
			System.out.println("else if2 ture");	//실행하지 않음
		}else if(a>0) {
			System.out.println("else if3 ture");	//실행함
		}else {
			System.out.println("else ture");		//실행하지 않음
		}
	}
}
