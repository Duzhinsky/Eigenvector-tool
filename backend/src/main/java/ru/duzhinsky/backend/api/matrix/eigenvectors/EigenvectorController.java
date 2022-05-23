package ru.duzhinsky.backend.api.matrix.eigenvectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.duzhinsky.backend.math.CharacteristicPolynomialCalculator;
import ru.duzhinsky.backend.math.LeverrierCalculator;
import ru.duzhinsky.backend.math.Matrix;
import ru.duzhinsky.backend.math.Polynomial;

@RestController
@RequestMapping("/matirxOperations/eigenvectors/")
public class EigenvectorController {
    @RequestMapping(method = RequestMethod.POST)
    public SolutionResponse solve(@RequestBody RequestMatrix inputedMatrix) {
        Matrix matrix = new Matrix();
        CharacteristicPolynomialCalculator calculator = new LeverrierCalculator();
        Polynomial characteristicPolynomial = calculator.getCharacteristicPolynomial(matrix);
        return new SolutionResponse(characteristicPolynomial);
    }
}