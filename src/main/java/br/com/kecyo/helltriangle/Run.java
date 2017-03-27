package br.com.kecyo.helltriangle;


import br.com.kecyo.helltriangle.usecases.AnalysisTriangle;
import br.com.kecyo.helltriangle.usecases.impl.AnalysisTriangleImpl;

public class Run {

    public static int start(int[][] array){
        AnalysisTriangle analysisTriangle = new AnalysisTriangleImpl();
        return analysisTriangle.maximumTotal(array);
    }

}
