package ru.duzhinsky.backend.math;

public class LeverrierCalculator implements CharacteristicPolynomialCalculator {
    @Override
    public Polynomial getCharacteristicPolynomial(Matrix m) {
        if(!m.isSquare())
            throw new IllegalArgumentException();

        int dim = m.getHeight();

        Double[] sValues = new Double[dim];
        Matrix A = Matrix.getIdentity(dim);
        for(int i = 0; i < dim; ++i) {
            A = A.mul(m);
            sValues[i] = A.trace();
        }

        Double[] aValues = new Double[dim+1];
        aValues[0] = 1.;
        for(int k = 1; k <= dim; ++k) {
            Double sum = sValues[k-1];
            for(int i = 1; i < k; ++i)
                sum += aValues[i]*sValues[k-i-1];
            aValues[k] = -sum/k;
        }

        return new Polynomial(aValues);
    }
}
