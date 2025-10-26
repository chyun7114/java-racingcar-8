package racingcar.game.view;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;

public class OutputView {

    private static final String RESULT_STRING = "\n실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printResultString() {
        System.out.println(RESULT_STRING);
    }

    public void printProcessOutput(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public void printWinners(List<String> winnerList) {
        System.out.println(FINAL_WINNER + String.join(", ", winnerList));
    }
}
