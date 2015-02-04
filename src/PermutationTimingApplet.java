/**
 * Created by andreahe on 1/27/15.
 */
import java.awt.*;
import java.applet.*;
import java.util.ArrayList;


import graph.*;

public class PermutationTimingApplet extends Applet {
    Graph2D graph;
    DataSet data1;
    DataSet data2;
    DataSet data3;
    Axis xaxis;
    Axis yaxis_left;


    public void init() {
        double d1[];
        double d2[];
        double d3[];

        //Graph setup
        graph = new Graph2D();
        graph.drawzero = false;
        graph.drawgrid = false;
        graph.borderTop = 50;
        graph.borderRight = 100;
        setLayout(new BorderLayout());
        add("Center", graph);

        //Generate timing data
        d1 = generateTimingData(new Algorithm1());
        d2 = generateTimingData(new Algorithm2());
        d3 = generateTimingData(new Algorithm3());

        data1 = graph.loadDataSet(d1, d1.length / 2);
        data1.linestyle = 1;
        data1.linecolor = new Color(0, 255, 0);
        data1.marker = 1;
        data1.markerscale = 1;
        data1.markercolor = new Color(0, 0, 255);
        data1.legend(200, 100, "Algorithm 1");
        data1.legendColor(Color.black);

        data2 = graph.loadDataSet(d2, d2.length / 2);
        data2.linestyle = 1;
        data2.linecolor = new Color(255, 0, 0);
        data2.marker = 1;
        data2.markerscale = 1;
        data2.markercolor = new Color(0, 0, 255);
        data2.legend(200, 120, "Algorithm 2");
        data2.legendColor(Color.black);

        data3 = graph.loadDataSet(d3, d3.length / 2);
        data3.linestyle = 1;
        data3.linecolor = new Color(0, 0, 255);
        data3.marker = 1;
        data3.markerscale = 1;
        data3.markercolor = new Color(0, 0, 255);
        data3.legend(200, 140, "Algorithm 3");
        data3.legendColor(Color.black);

        xaxis = graph.createAxis(Axis.BOTTOM);
        xaxis.attachDataSet(data1);
        xaxis.attachDataSet(data2);
        xaxis.attachDataSet(data3);
        xaxis.setTitleText("N (array length)");
        xaxis.setTitleFont(new Font("TimesRoman", Font.PLAIN, 20));
        xaxis.setLabelFont(new Font("Helvetica", Font.PLAIN, 15));
/*
**      Attach data sets to the Left Axis
*/
        yaxis_left = graph.createAxis(Axis.LEFT);
        yaxis_left.attachDataSet(data1);
        yaxis_left.attachDataSet(data2);
        yaxis_left.attachDataSet(data3);
        yaxis_left.setTitleText("Time (s)");
        yaxis_left.setTitleFont(new Font("TimesRoman", Font.PLAIN, 20));
        yaxis_left.setLabelFont(new Font("Helvetica", Font.PLAIN, 15));
        yaxis_left.setTitleColor(new Color(0, 0, 255));


    }

    public double[] generateTimingData(PermutationAlgorithm algorithm) {
        int dataSize = 100;
        ArrayList<Double> timingData = new ArrayList<Double>();
        TimeInterval t = new TimeInterval();
        do {
            t.startTiming();
            algorithm.permute(dataSize);
            t.endTiming();
            timingData.add((double) dataSize);
            timingData.add(t.getElapsedTime());
            System.out.println("dataSize is " + dataSize + " and time is " + t.getElapsedTime());
            dataSize = dataSize * 2;
        } while (dataSize < 7000000 && t.getElapsedTime() < 30);
        double timingDataArray[] = new double[timingData.size()];
        for (int i = 0; i < timingData.size(); i++) {
            timingDataArray[i] = timingData.get(i);
        }
        return timingDataArray;
    }
}