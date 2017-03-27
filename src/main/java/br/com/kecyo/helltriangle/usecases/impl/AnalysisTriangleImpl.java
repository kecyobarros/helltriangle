package br.com.kecyo.helltriangle.usecases.impl;

import br.com.kecyo.helltriangle.exception.InvalidTriangleException;
import br.com.kecyo.helltriangle.usecases.AnalysisTriangle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

public class AnalysisTriangleImpl implements AnalysisTriangle {

    public int maximumTotal(int[][] array){
        validateTriangle(array);
        return calculateTriangle(array);
    }

    private void validateTriangle(int[][] array) throws InvalidTriangleException {

        if (array.length <= 1){
            throw new InvalidTriangleException("Invalid size triangle");
        }

        for (int indice = 0; indice < array.length; indice++){
            if (array[indice].length != indice+1){
                throw new InvalidTriangleException("Invalid Triangle");
            }
        }
    }

    private int calculateTriangle(int[][] array){

        IntBinaryOperator operator = (num1, num2) -> {
          if (num1 > num2){
              return num1;
          }
            return num2;
        };

        Optional<int[]> reduce = Arrays.stream(array)
                .sorted(Comparator.comparing(Array::getLength).reversed())
                .map(ints ->  ints.clone())
                .reduce((row1, row2) -> {
                    for (int index = 0; index < row2.length; index++) {
                        row2[index] += operator.applyAsInt(row1[index], row1[index+1]);
                    }
                    return row2;
                });

        return reduce.orElse(new int[]{0})[0];
    }
}
