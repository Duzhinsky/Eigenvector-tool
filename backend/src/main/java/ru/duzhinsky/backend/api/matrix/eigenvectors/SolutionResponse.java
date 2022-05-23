package ru.duzhinsky.backend.api.matrix.eigenvectors;

import lombok.Getter;
import ru.duzhinsky.backend.math.Polynomial;

@Getter
public class SolutionResponse {
    private int[] characteristicPolynomial;
    public SolutionResponse(Polynomial polynomial) {
        characteristicPolynomial = new int[]{1,2,3};
    }
}
