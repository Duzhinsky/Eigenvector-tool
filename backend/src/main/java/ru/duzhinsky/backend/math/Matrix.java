package ru.duzhinsky.backend.math;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Matrix {
    private final List<List<Double>> values;
    @Getter
    private final int width;
    @Getter
    private final int height;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        this.values = new ArrayList<>(height);
        for(int i = 0; i < height; ++i) {
            var row = new ArrayList<>(Collections.nCopies(width, .0));
            values.add(row);
        }
    }

    public Matrix(Double[][] valuesArray) {
        this.height = valuesArray.length;
        this.width = height != 0 ? valuesArray[0].length : 0;
        this.values = new ArrayList<>(height);
        for(int i = 0; i < height; ++i) {
            var row = new ArrayList<>(Arrays.asList(valuesArray[i]));
            values.add(row);
        }
    }

    public boolean isSquare() {
        return this.width == this.height;
    }

    public static Matrix getIdentity(int dimension) {
        Double[][] values = new Double[dimension][dimension];
        for(int i = 0; i < dimension; ++i)
            for(int k = 0; k < dimension; ++k)
                values[i][k] = i == k ? 1. : 0.;
        return new Matrix(values);
    }

    public List<List<Double>> getValues() {
        return Collections.unmodifiableList(values);
    }

    public Matrix mul(Matrix other) {
        if(!isSquare())
            throw new IllegalArgumentException();
        Double[][] resultValues = new Double[this.height][other.width];
        for(int i = 0; i < this.height; ++i) {
            for(int k = 0; k < other.width; ++k) {
                double sum = .0;
                for(int j = 0; j < this.width; ++j)
                    sum += this.values.get(i).get(j) * other.values.get(j).get(k);
                resultValues[i][k] = sum;
            }
        }
        return new Matrix(resultValues);
    }

    public Matrix pow(int exp) {
        if(!isSquare())
            throw new IllegalArgumentException();
        Matrix result = Matrix.getIdentity(this.width);
        while(exp-->0)
            result = result.mul(this);
        return result;
    }

    public Double trace() {
        if(!isSquare())
            throw new IllegalArgumentException();
        Double tr = .0;
        for(int i = 0; i < width; ++i)
            tr += values.get(i).get(i);
        return tr;
    }
}