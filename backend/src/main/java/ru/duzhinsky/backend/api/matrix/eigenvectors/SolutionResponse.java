package ru.duzhinsky.backend.api.matrix.eigenvectors;

import lombok.Getter;
import ru.duzhinsky.backend.math.Polynomial;

@Getter
public class SolutionResponse {
    private final Double[] characteristicPolynomial;

    public SolutionResponse(Polynomial polynomial) {
        var coefficients = polynomial.getCoefficients();
        characteristicPolynomial = new Double[coefficients.size()];
        coefficients.toArray(characteristicPolynomial);
    }
}
