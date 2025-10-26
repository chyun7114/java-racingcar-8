package racingcar.service;

import racingcar.domain.Cars;

public interface CarMoveService {

    void moveCars(Cars cars, int tryCount);
}
