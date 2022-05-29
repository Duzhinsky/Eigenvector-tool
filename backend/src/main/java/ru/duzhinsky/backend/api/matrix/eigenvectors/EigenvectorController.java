package ru.duzhinsky.backend.api.matrix.eigenvectors;

import org.springframework.web.bind.annotation.*;
import ru.duzhinsky.backend.math.CharacteristicPolynomialCalculator;
import ru.duzhinsky.backend.math.LeverrierCalculator;
import ru.duzhinsky.backend.math.Matrix;
import ru.duzhinsky.backend.math.Polynomial;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/matirxOperations/eigenvectors/")
public class EigenvectorController {
    @RequestMapping(method = RequestMethod.POST)
    public SolutionResponse solve(@RequestBody Double[][] inputedMatrix) {
        Matrix matrix = new Matrix(inputedMatrix);
        CharacteristicPolynomialCalculator calculator = new LeverrierCalculator();
        Polynomial characteristicPolynomial = calculator.getCharacteristicPolynomial(matrix);
        return new SolutionResponse(characteristicPolynomial);
    }
}