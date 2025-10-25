package racingcar.service;

import racingcar.domain.Cars;

public interface CarMoveService {

    void moveCar(Cars cars, int tryCount);
}
