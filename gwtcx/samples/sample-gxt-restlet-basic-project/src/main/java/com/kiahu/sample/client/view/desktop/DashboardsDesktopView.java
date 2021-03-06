/**
 * (C) Copyright 2012 Kiahu
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.kiahu.sample.client.view.desktop;

import java.util.Date;

import org.moxieapps.gwt.highcharts.client.Axis;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Color;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.Style;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.XAxis;
import org.moxieapps.gwt.highcharts.client.YAxis;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.FunnelDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.Labels;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.PlotBandLabel;
import org.moxieapps.gwt.highcharts.client.labels.PyramidDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.AreaPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.BarPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.FunnelPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PyramidPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.SplinePlotOptions;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.gwtcx.client.uihandlers.DashboardsUiHandlers;
import com.gwtcx.extgwt.client.desktop.view.AbstractDashboardsDesktopView;
import com.kiahu.sample.client.presenter.DashboardsPresenter;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;

public class DashboardsDesktopView extends AbstractDashboardsDesktopView<DashboardsUiHandlers> implements
    DashboardsPresenter.MyView {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CHART_WIDTH = "500px";
  public static final String CHART_HEIGHT = "420px";

  protected HorizontalLayoutContainer northLayout;
  protected HorizontalLayoutContainer southLayout;

  // @Inject
  public DashboardsDesktopView() {
    super();

    Log.debug("DashboardsDesktopView()");

    getPanel().setStyleName("gwtcx-Dashboards-View");  // overflow: auto;

    if (GWT.isScript()) {

      // North Layout

      northLayout = new HorizontalLayoutContainer();
      northLayout.setSize(CONTEXT_AREA_WIDTH, CHART_HEIGHT);

      this.panel.add(northLayout);  // , new VerticalLayoutData(1, 0.5));

      // Chart 1

      final Chart chart1 = createFunnelChart();
      chart1.setSize(CHART_WIDTH, CHART_HEIGHT);
      final SimpleContainer chart1Container = new SimpleContainer();
      chart1Container.setSize(CHART_WIDTH, CHART_HEIGHT);

      northLayout.add(chart1Container);
      chart1Container.add(chart1);

      // Chart 2

      final Chart chart2 = createPyramidChart();
      chart2.setSize(CHART_WIDTH, CHART_HEIGHT);
      final SimpleContainer chart2Container = new SimpleContainer();
      chart2Container.setSize(CHART_WIDTH, CHART_HEIGHT);

      northLayout.add(chart2Container);
      chart2Container.add(chart2);

      // South Layout

      southLayout = new HorizontalLayoutContainer();
      northLayout.setSize(CONTEXT_AREA_WIDTH, CHART_HEIGHT);

      this.panel.add(southLayout);  // , new VerticalLayoutData(1, 0.5));

      // Chart 3

      final Chart chart3 = createBasicPieChart();
      chart3.setSize(CHART_WIDTH, CHART_HEIGHT);
      final SimpleContainer chart3Container = new SimpleContainer();
      chart3Container.setSize(CHART_WIDTH, CHART_HEIGHT);

      southLayout.add(chart3Container);
      chart3Container.add(chart3);

      // Chart 4

      final Chart chart4 = createDonutChart();
      chart4.setSize(CHART_WIDTH, CHART_HEIGHT);
      final SimpleContainer chart4Container = new SimpleContainer();
      chart4Container.setSize(CHART_WIDTH, CHART_HEIGHT);

      southLayout.add(chart4Container);
      chart4Container.add(chart4);
    }
  }

  /*

      northLayout = new HorizontalLayoutContainer();
      northLayout.setHeight("100%");
      northLayout.setWidth("100%");

      this.panel.add(northLayout) ;  // , new VerticalLayoutData(1, -1));

      final Chart chart1 = createFunnelChart();
      chart1.setSize("500px", "420px");
      final SimpleContainer chart1Container = new SimpleContainer();
      chart1Container.setSize("500px", "420px");

      northLayout.add(chart1Container);  // , new HorizontalLayoutData(-1, 1));
      chart1Container.add(chart1);


      final Chart chart2 = createPyramidChart();
      chart2.setSize("500px", "420px");
      final SimpleContainer chart2Container = new SimpleContainer();
      chart2Container.setSize("500px", "420px");

      northLayout.add(chart2Container);  // , new HorizontalLayoutData(-1, 1));
      chart2Container.add(chart2);

  */



  /*




      southLayout = new HorizontalLayoutContainer();
      southLayout.setHeight("50%");
      southLayout.setWidth("100%");

      panel.add(southLayout, new VerticalLayoutData(1, -1));

      final Chart chart3 = createBasicPieChart();
      chart3.setSize("500px", "420px");
      final SimpleContainer chart3Container = new SimpleContainer();
      chart3Container.setSize("500px", "420px");

      southLayout.add(chart3Container);
      chart3Container.add(chart3);





      final Chart chart2 = createPyramidChart();
      chart2.setSize("500px", "420px");

      northLayout.add(chart1, new HorizontalLayoutData(-1, 1));
      northLayout.add(chart2, new HorizontalLayoutData(-1, 1));


      southLayout = new HorizontalLayoutContainer();
      southLayout.setHeight("50%");
      southLayout.setWidth("100%");

      panel.add(southLayout, new VerticalLayoutData(1, -1));

      final Chart chart3 = createBasicPieChart();
      chart3.setSize("500px", "420px");

      final Chart chart4 = createDonutChart();
      chart4.setSize("500px", "420px");

      southLayout.add(chart3, new HorizontalLayoutData(-1, 1));
      southLayout.add(chart4, new HorizontalLayoutData(-1, 1));









    if (GWT.isScript()) {

        FlowPanel northLayout = new FlowPanel();
        northLayout.setStyleName("gwtcx-Dashboards-View-Container");
        northLayout.setHeight("100%");
        northLayout.setWidth("100%");

        panel.add(northLayout);

        final Chart chart1 = createDynamicSplineChart(); // createDynamicSplineChart createFunnelChart
        chart1.setSize("960px", "420px");
        final SimpleContainer chart1Container = new SimpleContainer();
        chart1Container.setSize("960px", "420px");

        northLayout.add(chart1Container);
        chart1Container.add(chart1);
    }


    if (GWT.isScript()) {

        FlowPanel northLayout = new FlowPanel();
        northLayout.setStyleName("gwtcx-Dashboards-View-Container");
        // northLayout.setHeight("50%");
        northLayout.setHeight("100%");
        northLayout.setWidth("100%");

        // FlowPanel southLayout = new FlowPanel();
        // southLayout.setStyleName("gwtcx-Dashboards-View-Container");
        // southLayout.setHeight("50%");
        // southLayout.setWidth("100%");

        panel.add(northLayout);
        // panel.add(southLayout);

        final Chart chart1 = createDynamicSplineChart(); // createDynamicSplineChart createFunnelChart
        // chart1.setWidth100();
        chart1.setSize("800px", "420px");
        final SimpleContainer chart1Container = new SimpleContainer();
        chart1Container.setSize("800px", "420px");

        final Chart chart2 = createPyramidChart();
        // chart2.setWidth100();
        chart2.setSize("500px", "420px");
        final SimpleContainer chart2Container = new SimpleContainer();
        chart2Container.setSize("500px", "420px");

        northLayout.add(chart1Container);
        // southLayout.add(chart2Container);
        northLayout.add(chart2Container);
        chart1Container.add(chart1);
        chart2Container.add(chart2);
        // chart1Container.clear();
        // chart1Container.remove(chart1);
        // chart1Container.add(chart1);
    }


  /*/

  @Override
  protected void bindCustomUiHandlers() {
    super.bindCustomUiHandlers();
  }

  // public void setResultSet() { }

  public Chart createFunnelChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.FUNNEL)
          .setChartTitleText("<b>" + "Funnel Chart" + "</b>")
          // .setNeckWidth("100%")
          // .setNeckHeight("0%")
          .setMargin(50, 10, 60, 170)
          .setPlotBackgroundColor((String) null)
          .setPlotBorderWidth(null)
          .setPlotShadow(false)
          .setFunnelPlotOptions(new FunnelPlotOptions()
              .setFunnelDataLabels(new FunnelDataLabels()
              .setAlign(Labels.Align.LEFT)
              .setX(-300)
              .setEnabled(true)
              .setColor("#000000")
                  .setFormatter(new DataLabelsFormatter() {
                      public String format(DataLabelsData dataLabelsData) {
                          // return dataLabelsData.getPointName();
                          return "<b>" + dataLabelsData.getPointName() + "</b>: (" +
                          NumberFormat.getFormat("#,###").format(dataLabelsData.getYAsDouble()) + ")";
                      }
                  })
              )
          )
          .setLegend(new Legend()
            .setEnabled(false)
          )
          .setCredits(new Credits()
            .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getPointName() + "</b>: " +
                      NumberFormat.getFormat("#,###").format(toolTipData.getYAsDouble());
                  }
              })
          );

      // chart.setWidth("0%");

      chart.addSeries(chart.createSeries()
          .setName("Lifecycle")
          .setPoints(new Point[]{
              new Point("Impressions", 15654),
              new Point("Clicks", 4064),
              new Point("Downloads", 1987),
              new Point("Purchase", 976),
              new Point("Repeat Purchase", 846)
          })


      /*

      chart.addSeries(chart.createSeries()
          .setName("Lifecycle")
          .setPoints(new Point[]{
              new Point("Repeat Purchase", 846),
              new Point("Purchase", 976),
              new Point("Downloads", 1987),
              new Point("Clicks", 4064),
              new Point("Impressions", 15654)
          })

      */

      );

      return chart;
  }


  public Chart createPyramidChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.PYRAMID)
          .setChartTitleText("<b>" + "Pyramid Chart" + "</b>")
          // .setNeckWidth("100%")
          // .setNeckHeight("0%")
          .setMargin(50, 10, 60, 170)
          .setPlotBackgroundColor((String) null)
          .setPlotBorderWidth(null)
          .setPlotShadow(false)
          .setPyramidPlotOptions(new PyramidPlotOptions()
              .setPyramidDataLabels(new PyramidDataLabels()
              // .setAlign(Labels.Align.LEFT)
              // .setX(-300)
              .setEnabled(true)
              .setColor("#000000")
                  .setFormatter(new DataLabelsFormatter() {
                      public String format(DataLabelsData dataLabelsData) {
                          // return dataLabelsData.getPointName();
                          return "<b>" + dataLabelsData.getPointName() + "</b>: (" +
                          NumberFormat.getFormat("#,###").format(dataLabelsData.getYAsDouble()) + ")";
                      }
                  })
              )
          )
          .setLegend(new Legend()
            .setEnabled(false)
          )
          .setCredits(new Credits()
            .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getPointName() + "</b>: " +
                      NumberFormat.getFormat("#,###").format(toolTipData.getYAsDouble());
                  }
              })
          );

      // chart.setWidth("0%");

      chart.addSeries(chart.createSeries()
          .setName("Lifecycle")
          .setPoints(new Point[]{
              new Point("Repeat Purchase", 846),
              new Point("Purchase", 976),
              new Point("Downloads", 1987),
              new Point("Clicks", 4064),
              new Point("Impressions", 15654)
          })
      );

      return chart;
  }


  public Chart createBasicPieChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.PIE)
          .setChartTitleText("<b>" + "Pie Chart" + "</b>")
          // .setMargin(10, 10, 10, 10)
          .setPlotBackgroundColor((String) null)
          .setPlotBorderWidth(null)
          .setPlotShadow(false)
          .setPiePlotOptions(new PiePlotOptions()
              .setAllowPointSelect(true)
              .setCursor(PlotOptions.Cursor.POINTER)
              .setPieDataLabels(new PieDataLabels()
                  .setConnectorColor("#000000")
                  .setEnabled(true)
                  .setColor("#000000")
                  .setFormatter(new DataLabelsFormatter() {
                      public String format(DataLabelsData dataLabelsData) {
                          return dataLabelsData.getPointName() + ": " + dataLabelsData.getYAsDouble() + " %";
                      }
                  })
              )
          )
          .setLegend(new Legend()
            .setEnabled(false)
          )
          .setCredits(new Credits()
            .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";
                  }
              })
          );

      chart.addSeries(chart.createSeries()
          .setName("Lifecycle")
          .setPoints(new Point[]{
              new Point("Impressions", 45.0),
              new Point("Clicks", 26.8),
              new Point("Downloads", 12.8)
                  .setSliced(true)
                  .setSelected(true),
              new Point("Purchase", 8.5),
              new Point("Repeat Purchase", 6.9)
          })
      );

      return chart;
  }


  public Chart createDonutChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.PIE)
          .setMargin(50, 0, 0, 0)
          .setChartTitleText("<b>" + "Donut Chart" + "</b>")
          .setChartSubtitleText("Browser Market Share - Inner circle: 2010, Outer circle: 2011")
          .setPlotBackgroundColor("none")
          .setPlotBorderWidth(0)
          .setPlotShadow(false)
          .setCredits(new Credits()
            .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getSeriesName() + "</b><br/>" +
                          toolTipData.getPointName() + ": " + toolTipData.getYAsDouble() + " %";
                  }
              })
          );

      chart.addSeries(chart.createSeries()
          .setName("2010")
          .setPlotOptions(new PiePlotOptions()
              .setSize(.45)
              .setInnerSize(.20)
              .setDataLabels(new DataLabels()
                  .setEnabled(false)
              )
          )
          .setPoints(new Point[]{
              new Point("Firefox", 44.2).setColor("#4572A7"),
              new Point("IE", 46.6).setColor("#AA4643"),
              new Point("Chrome", 3.1).setColor("#89A54E"),
              new Point("Safari", 2.7).setColor("#80699B"),
              new Point("Opera", 2.3).setColor("#3D96AE"),
              new Point("Others", 0.4).setColor("#DB843D")
          })
      );

      chart.addSeries(chart.createSeries()
          .setName("2011")
          .setPlotOptions(new PiePlotOptions()
              .setInnerSize(.45)
              .setPieDataLabels(new PieDataLabels()
                  .setEnabled(true)
                  .setColor("#000000")
                  .setConnectorColor("#000000")
              )
          )
          .setPoints(new Point[]{
              new Point("Firefox", 45.0).setColor("#4572A7"),
              new Point("IE", 26.8).setColor("#AA4643"),
              new Point("Chrome", 12.8).setColor("#89A54E"),
              new Point("Safari", 8.5).setColor("#80699B"),
              new Point("Opera", 6.2).setColor("#3D96AE"),
              new Point("Others", 0.2).setColor("#DB843D")
          })
      );

      return chart;
  }

  public Chart createSplineWithPlotBandsChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.SPLINE)
          .setChartTitleText("Wind speed during two days")
          .setChartSubtitleText("October 6th and 7th 2009 at two locations in Vik i Sogn, Norway")
          .setLegend(new Legend()
              .setEnabled(false)
          )
          .setCredits(new Credits()
              .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return DateTimeFormat.getFormat("d. MMMM YYYY HH:00").format(
                          new Date(toolTipData.getXAsLong())
                      ) + ": " + toolTipData.getYAsDouble() + " m/s";
                  }
              })
          )
          .setSplinePlotOptions(new SplinePlotOptions()
              .setLineWidth(4)
              .setHoverStateLineWidth(5)
              .setMarker(new Marker()
                  .setEnabled(false)
                  .setHoverState(new Marker()
                      .setEnabled(true)
                      .setSymbol(Marker.Symbol.CIRCLE)
                      .setRadius(5)
                      .setLineWidth(1)
                  )
              )
              .setPointInterval(3600000)  // one hour
              .setPointStart(
                  DateTimeFormat.getFormat("yyyy-MM-dd").parse("2009-10-06").getTime()
              )
          );

      chart.getXAxis()
          .setType(Axis.Type.DATE_TIME);

      final YAxis axis = chart.getYAxis();
      final Color blueColor = new Color(68, 170, 213, 0.1);
      final Color clearColor = new Color(0, 0, 0, 0);
      axis.setAxisTitleText("Wind speed (m/s)")
          .setMin(0)
          .setMinorGridLineWidth(0)
          .setGridLineWidth(0)
          .setAlternateGridColor(null)
          .setPlotBands(
              axis.createPlotBand()   // Light air
                  .setFrom(0.3)
                  .setTo(1.5)
                  .setColor(blueColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Light air")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Light breeze
                  .setFrom(1.5)
                  .setTo(3.3)
                  .setColor(clearColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Light breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Gentle breeze
                  .setFrom(3.3)
                  .setTo(5.5)
                  .setColor(blueColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Gentle breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Moderate breeze
                  .setFrom(5.5)
                  .setTo(8)
                  .setColor(clearColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Moderate breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Fresh breeze
                  .setFrom(8)
                  .setTo(11)
                  .setColor(blueColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Fresh breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // Strong breeze
                  .setFrom(11)
                  .setTo(14)
                  .setColor(clearColor)
                  .setLabel(new PlotBandLabel()
                      .setText("Strong breeze")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  ),
              axis.createPlotBand()   // High wind
                  .setFrom(14)
                  .setTo(15)
                  .setColor(blueColor)
                  .setLabel(new PlotBandLabel()
                      .setText("High wind")
                      .setStyle(new Style()
                          .setColor("#606060")
                      )
                  )
          );

      chart.addSeries(chart.createSeries()
          .setName("Hestavollane")
          .setPoints(new Number[]{
              4.3, 5.1, 4.3, 5.2, 5.4, 4.7, 3.5, 4.1, 5.6, 7.4, 6.9, 7.1,
              7.9, 7.9, 7.5, 6.7, 7.7, 7.7, 7.4, 7.0, 7.1, 5.8, 5.9, 7.4,
              8.2, 8.5, 9.4, 8.1, 10.9, 10.4, 10.9, 12.4, 12.1, 9.5, 7.5,
              7.1, 7.5, 8.1, 6.8, 3.4, 2.1, 1.9, 2.8, 2.9, 1.3, 4.4, 4.2,
              3.0, 3.0
          })
      );
      chart.addSeries(chart.createSeries()
          .setName("Voll")
          .setPoints(new Number[] {
              0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.3, 0.0,
              0.0, 0.4, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
              0.0, 0.6, 1.2, 1.7, 0.7, 2.9, 4.1, 2.6, 3.7, 3.9, 1.7, 2.3,
              3.0, 3.3, 4.8, 5.0, 4.8, 5.0, 3.2, 2.0, 0.9, 0.4, 0.3, 0.5, 0.4
          })
      );

      return chart;
  }


  public Chart createStackedAreaChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.AREA)
          .setChartTitleText("Historic and Estimated Worldwide Population Growth by Region")
          .setChartSubtitleText("Source: Wikipedia.org")
          .setAreaPlotOptions(new AreaPlotOptions()
              .setStacking(PlotOptions.Stacking.NORMAL)
              .setLineColor("#666666")
              .setLineWidth(1)
              .setMarker(new Marker()
                  .setLineWidth(1)
                  .setLineColor("#666666")
              )
          )
          .setToolTip(new ToolTip()
              .setFormatter(
                  new ToolTipFormatter() {
                      public String format(ToolTipData toolTipData) {
                          return toolTipData.getXAsDouble() + ": " +
                              NumberFormat.getFormat("#,###").format(toolTipData.getYAsDouble()) + " millions";
                      }
                  }
              )
          );

      chart.getXAxis()
          .setCategories(
              "1750", "1800", "1850", "1900", "1950", "1999", "2050"
          )
          .setTickmarkPlacement(XAxis.TickmarkPlacement.ON)
          .setAxisTitleText(null);

      chart.getYAxis()
          .setAxisTitleText("Billions")
          .setLabels(new YAxisLabels()
              .setFormatter(
                  new AxisLabelsFormatter() {
                      public String format(AxisLabelsData axisLabelsData) {
                          return String.valueOf(axisLabelsData.getValueAsLong() / 1000);
                      }
                  }
              )
          );

      chart.addSeries(chart.createSeries()
          .setName("Asia")
          .setPoints(new Number[] { 502, 635, 809, 947, 1402, 3634, 5268 })
      );
      chart.addSeries(chart.createSeries()
          .setName("Africa")
          .setPoints(new Number[] { 106, 107, 111, 133, 221, 767, 1766 })
      );
      chart.addSeries(chart.createSeries()
          .setName("Europe")
          .setPoints(new Number[] { 163, 203, 276, 408, 547, 729, 628 })
      );
      chart.addSeries(chart.createSeries()
          .setName("America")
          .setPoints(new Number[] { 18, 31, 54, 156, 339, 818, 1201 })
      );
      chart.addSeries(chart.createSeries()
          .setName("Oceania")
          .setPoints(new Number[] { 2, 2, 2, 6, 13, 30, 46 })
      );

      return chart;
  }


  public Chart createDynamicSplineChart() {

      final Chart chart = new Chart()
          .setType(Series.Type.SPLINE)
          .setMarginRight(10)
          .setChartTitleText("Live random data")
          .setBarPlotOptions(new BarPlotOptions()
              .setDataLabels(new DataLabels()
                  .setEnabled(true)
              )
          )
          .setLegend(new Legend()
              .setEnabled(false)
          )
          .setCredits(new Credits()
              .setEnabled(false)
          )
          .setToolTip(new ToolTip()
              .setFormatter(new ToolTipFormatter() {
                  public String format(ToolTipData toolTipData) {
                      return "<b>" + toolTipData.getSeriesName() + "</b><br/>" +
                          DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss")
                              .format(new Date(toolTipData.getXAsLong())) + "<br/>" +
                          NumberFormat.getFormat("0.00").format(toolTipData.getYAsDouble());
                  }
              })
          );

      chart.getXAxis()
          .setType(Axis.Type.DATE_TIME)
          .setTickPixelInterval(150);

      chart.getYAxis()
          .setAxisTitleText("Value")
          .setPlotLines(
              chart.getYAxis().createPlotLine()
                  .setValue(0)
                  .setWidth(1)
                  .setColor("#808080")
          );

      final Series series = chart.createSeries();
      chart.addSeries(series
          .setName("Random data")
      );

      // Generate an array of random data
      long time = new Date().getTime();
      for(int i = -19; i <= 0; i++) {
          series.addPoint(time + i * 1000, com.google.gwt.user.client.Random.nextDouble());
      }

      Timer tempTimer = new Timer() {
          @Override
          public void run() {
              series.addPoint(
                  new Date().getTime(),
                  com.google.gwt.user.client.Random.nextDouble(),
                  true, true, true
              );
          }
      };
      tempTimer.scheduleRepeating(1000);

      return chart;
  }
}

/*

By default the Highcharts exporting module sends an SVG representation of the chart by POST to http://export.highcharts.com, where it is converted using Apache's Batik converter to PDF, PNG or JPEG. You could theoretically setup your own instance of Apache Batik on your demo machine though and then change the post URL of the exporting module like so:

    Chart chart = new Chart()
        .setExporting(new Exporting()
            .setEnabled(true)
            .setUrl("http://my.local.batik.converter/")
        );

I haven't tried that myself though, so that's just a theory. Note that you can find some more details on the Highcharts exporting module here (although not much):

http://www.highcharts.com/documentation/how-to-use#exporting

Let us know if you're able to pull this off!

*/



/*

VerticalLayoutContainer northLayout = new VerticalLayoutContainer();

Label label1 = new Label("Test Label 1");
label1.addStyleName(ThemeStyles.getStyle().border());
label1.addStyleName("pad-text white-bg");

Label label2 = new Label("Test Label 2");
label2.addStyleName(ThemeStyles.getStyle().border());
label2.addStyleName("pad-text white-bg");

Label label3 = new Label("Test Label 3");
label3.addStyleName(ThemeStyles.getStyle().border());
label3.addStyleName("pad-text white-bg");

northLayout.add(label1, new VerticalLayoutData(1, .5d, new Margins(4)));
northLayout.add(label2, new VerticalLayoutData(1, -200, new Margins(0, 4, 0, 4)));
northLayout.add(label3, new VerticalLayoutData(1, .5d, new Margins(4)));

panel.add(northLayout);

*/



/*

// panel.setOverflow(Overflow.AUTO);

if (GWT.isScript()) {

  FlowPanel northLayout = new FlowPanel();
  northLayout.setHeight("50%");
  northLayout.setWidth("100%");
  // northLayout.setBackgroundColor("white");
  // northLayout.setMembersMargin(8);

  final Chart chart1 = createFunnelChart();
  chart1.setSize("500", "420");

  northLayout.add(chart1);

  panel.add(northLayout);
}

*/