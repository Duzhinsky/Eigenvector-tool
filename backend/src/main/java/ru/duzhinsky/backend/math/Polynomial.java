package ru.duzhinsky.backend.math;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Polynomial {
    private final List<Double> coefficients;
    @Getter
    private final int degree;

    public Polynomial(int degree) {
        this.degree = degree;
        this.coefficients = new ArrayList<>(Collections.nCopies(degree, .0));
    }

    public Polynomial(List<Double> list) {
        this.degree = list.size();
        this.coefficients = List.copyOf(list);
    }

    public Polynomial(Double[] array) {
        this.degree = array.length;
        this.coefficients = List.of(array);
    }

    public List<Double> getCoefficients() {
        return Collections.unmodifiableList(coefficients);
    }
}
