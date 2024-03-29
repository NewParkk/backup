package step02.domain;


public class Car {
	private int carNo;
	private String carName;
	
	public Car(){
		System.out.println("자동차 기본 생성자");
	}
	public Car(int carNo, String carName) {
		this.carNo = carNo;
		this.carName = carName;
		System.out.println("자동차 일반 생성자");
	}
	
	public int getCarNo() {
		return carNo;
	}
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	public String getcarName() {
		return carName;
	}
	public void setcarName(String carName) {
		this.carName = carName;
	}
	
	@Override
	public String toString() {
		return "Car [carNo=" + carNo + ", carName=" + carName + "]";
	}
}