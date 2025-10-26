package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void printProcessOutput(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }
}
