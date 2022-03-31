package tqs.lab3_2;

public class CarDTO {
    private Long carId;
    private String maker;
    private String model;

    public static CarDTO fromCarEntity(Car car){
        return new CarDTO(car.getCarId(), car.getMaker(), car.getModel());
    }
    public Car toCarEntity(){
        return new Car(getCarId(), getMaker(), getModel());
    }

    public CarDTO(){};

    public CarDTO(Long carId, String maker, String model) {
        this.carId = carId;
        this.maker = maker;
        this.model = model;
    }

    public Long getCarId() {
        return this.carId;
    }

    public void setCarId(Long id) {
        this.carId = id;
    }

    public String getMaker() {
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}
