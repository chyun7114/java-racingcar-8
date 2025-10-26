package racingcar.car.service;

import java.util.List;
import racingcar.car.domain.Cars;

public interface CarWinnerService {
    List<String> getWinner(Cars cars);
}
