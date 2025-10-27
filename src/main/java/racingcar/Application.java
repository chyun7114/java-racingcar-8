package racingcar;

import racingcar.core.config.AppConfig;
import racingcar.game.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = AppConfig.getInstance().gameController();
        gameController.start();
    }
}
