package racingcar.car.service;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.infrastructure.generator.RandomNumberGenerator;

public class CarMoveServiceImpl implements CarMoveService {

    private final RandomNumberGenerator randomNumberGenerator;

    public CarMoveServiceImpl(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void moveCars(Cars cars) {
        moveCarByRandomNumber(cars.getCarList());
        updateMaxDistance(cars);
    }

    private void moveCarByRandomNumber(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    private void updateMaxDistance(Cars cars) {
        int currentMax = cars.getCarList().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Integer.MIN_VALUE);

        cars.setMaxDistance(currentMax);
    }
}
