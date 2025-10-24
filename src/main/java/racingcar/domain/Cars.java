package racingcar.domain;

import java.util.List;

public class Cars {

    private final List<Car> carList;
    private int maxDistance;

    public Cars(List<Car> carList) {
        this.carList = carList;
        this.maxDistance = Integer.MIN_VALUE;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public int getMaxDistance() {
        return this.maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }
}
