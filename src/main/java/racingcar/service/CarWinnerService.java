package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;

public interface CarWinnerService {
    List<String> getWinner(Cars cars);
}
