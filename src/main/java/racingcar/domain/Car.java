package racingcar.domain;

import java.math.BigInteger;

public class Car {

    private String name;
    private BigInteger position;

    public Car(String name) {
        this.name = name;
        this.position = BigInteger.ZERO;
    }

    public String getName() {
        return this.name;
    }

    public BigInteger getPosition() {
        return this.position;
    }

    public void move() {
        this.position = this.position.add(BigInteger.ONE);
    }
}
