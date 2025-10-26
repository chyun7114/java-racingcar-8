package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.infrastructure.generator.RandomNumberGenerator;
import racingcar.view.OutputView;

public class CarMoveServiceImpl implements CarMoveService {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final OutputView outputView = new OutputView();

    @Override
    public void moveCars(Cars cars, int tryCount) {
        List<Car> carList = cars.getCarList();

        for (int i = 0; i < tryCount; i++) {
            moveCarByRandomNumber(carList);
            updateMaxDistance(cars);
            printMoveResult(cars);
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

    private void printMoveResult(Cars cars) {
        outputView.printProcessOutput(cars);
        System.out.println();
    }
}
