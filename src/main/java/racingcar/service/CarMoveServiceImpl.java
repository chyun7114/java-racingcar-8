package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.infrastructure.generator.RandomNumberGenerator;

public class CarMoveServiceImpl implements CarMoveService {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Override
    public void moveCar(Cars cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            List<Car> carList = cars.getCarList();

            moveCarByRandomNumber(carList);

            updateMaxDistance(cars);
        }
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
