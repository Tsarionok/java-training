package by.tsarionok.controller;

import by.tsarionok.entity.RightHexagon;
import by.tsarionok.service.RightHexagonService;

public class Runner {
    public static void main(String[] args) {
        RightHexagon hexagon = new RightHexagon(3.4d);
        RightHexagon hexagonNonValidate = new RightHexagon(-5.4d);

        RightHexagonService hexagonService = new RightHexagonService(hexagon);
        System.out.println(hexagonService.hexagonSquare());

        hexagonService.setHexagon(hexagonNonValidate);
        System.out.println(hexagonService.hexagonSquare());
    }
}
