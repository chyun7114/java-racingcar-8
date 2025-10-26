package racingcar.car.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;

public class CarWinnerServiceImpl implements CarWinnerService {

    @Override
    public List<String> getWinner(Cars cars) {
        int maxDistance = cars.getMaxDistance();

        return getWinnerList(cars.getCarList(), maxDistance);
    }

    private List<String> getWinnerList(List<Car> carList, int maxDistance) {
        List<String> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (isWinner(car, maxDistance)) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    private boolean isWinner(Car car, int maxDistance) {
        return car.getPosition() == maxDistance;
    }
}
