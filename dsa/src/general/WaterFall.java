package com.example.demo5;

public class WaterFall {

    public static void main(String[] args) {
        waterfallStreams(new double[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}}, 3);
    }

    public static double[] waterfallStreams(double[][] array,
                                            int source) {
        double[] output = new double[array[0].length];
        getWaterFallStreamResult(array, output, 0, source, 100, 0);
        return output;
    }

    public static void getWaterFallStreamResult(double[][] array,
                                                double[] output,
                                                int row,
                                                int column,
                                                double sum,
                                                int from) {
        if (row == array.length - 1) {
            output[column] += sum;
            return;
        }
        if (column == array[0].length || column < 0) {
            return;
        }
        if (array[row + 1][column] == 1) {
            if (from == 0) {
                if (column != 0 && array[row][column - 1] != 1) {
                    getWaterFallStreamResult(array, output, row, column - 1, sum / 2, -1);
                }
                if (column != output.length - 1 && array[row][column + 1] != 1) {
                    getWaterFallStreamResult(array, output, row, column + 1, sum / 2, 1);
                }
            } else {
                getWaterFallStreamResult(array, output, row, column + from, sum, from);
            }
            return;
        }
        getWaterFallStreamResult(array, output, row + 1, column, sum, 0);
    }
}
