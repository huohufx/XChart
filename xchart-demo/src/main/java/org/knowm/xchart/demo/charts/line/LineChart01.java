package org.knowm.xchart.demo.charts.line;

import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler.CardinalPosition;

/**
 * Logarithmic Y-Axis
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>Logarithmic Y-Axis
 *   <li>Building a Chart with ChartBuilder
 *   <li>Place legend at Inside-NW position
 */
public class LineChart01 implements ExampleChart<XYChart> {

  public static void main(String[] args) {

    ExampleChart<XYChart> exampleChart = new LineChart01();
    XYChart chart = exampleChart.getChart();
    new SwingWrapper<XYChart>(chart).displayChart();
  }

  @Override
  public XYChart getChart() {

    // generates Log data
    List<Integer> xData = new ArrayList<Integer>();
    List<Double> yData = new ArrayList<Double>();
    for (int i = -3; i <= 3; i++) {
      xData.add(i);
      yData.add(Math.pow(10, i));
    }

    // Create Chart
    XYChart chart =
        new XYChartBuilder()
            .width(800)
            .height(600)
            .title("Powers of Ten")
            .xAxisTitle("Power")
            .yAxisTitle("Value")
            .build();

    // Customize Chart
    chart.getStyler().setChartTitleVisible(true);
    chart.getStyler().setLegendPosition(CardinalPosition.InsideNW);
    chart.getStyler().setYAxisLogarithmic(true);
    chart.getStyler().setXAxisLabelRotation(45);

    // chart.getStyler().setXAxisLabelAlignment(TextAlignment.Right);
    // chart.getStyler().setXAxisLabelRotation(90);
    // chart.getStyler().setXAxisLabelRotation(0);

    // Series
    chart.addSeries("10^x", xData, yData);

    return chart;
  }

  @Override
  public String getExampleChartName() {

    return getClass().getSimpleName() + " -  Logarithmic Y-Axis";
  }
}
