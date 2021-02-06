<template>
  <div class="container">
    <h3> Home page</h3>
    <img style="width:250px;height: 230px" src="../../public/logo.svg" alt="Kiwi standing on oval">

    <div class="row justify-content-start">
      <div class="col-8">

        <div id="arc"></div>
      </div>
      <div class="col-4" style="padding-top: 17%;">
        <div class="analtics"><label> Number for Building : </label> <span> 20</span></div>
        <div class="analtics"><label> Number for Tasks    : </label> <span> 20</span></div>
        <div class="analtics"><label> Number for Employee : </label> <span> 20</span></div>
      </div>
    </div>


  </div>
</template>

<script>
import * as d3 from "d3";
import ActivityDataService from "@/services/ActivityDataService";

export default {
  name: "Activities-list",
  data() {
    return {
      gdp: []
    };
  },

  created() {
    ActivityDataService.findByUsersActivity().then(response => {
      this.gdp = response.data;
      this.generateArc();
    }).catch(e => {
      console.log(e);
    });
  },

  methods: {
    generateArc() {

      console.log(this.gdp);

      const w = 500;
      const h = 500;

      const svg = d3
          .select("#arc")
          .append("svg")
          .attr("width", w)
          .attr("height", h);

      const sortedGDP = this.gdp.sort((a, b) => (a.value > b.value ? 1 : -1));
      const color = d3.scaleOrdinal(d3.schemeDark2);

      const max_gdp = d3.max(sortedGDP, o => o.totalActivities);

      const angleScale = d3
          .scaleLinear()
          .domain([0, max_gdp])
          .range([0, 1.5 * Math.PI]);

      const arc = d3
          .arc()
          .innerRadius((d, i) => (i + 1) * 25)
          .outerRadius((d, i) => (i + 2) * 25)
          .startAngle(angleScale(0))
          .endAngle(d => angleScale(d.totalActivities));

      const g = svg.append("g");

      g.selectAll("path")
          .data(sortedGDP)
          .enter()
          .append("path")
          .attr("d", arc)
          .attr("fill", (d, i) => color(i))
          .attr("stroke", "#FFF")
          .attr("stroke-width", "1px")
          .on("mouseenter", function () {
            d3.select(this)
                .transition()
                .duration(200)
                .attr("opacity", 0.5);
          })
          .on("mouseout", function () {
            d3.select(this)
                .transition()
                .duration(200)
                .attr("opacity", 1);
          });

      g.selectAll("text")
          .data(this.gdp)
          .enter()
          .append("text")
          .text(d => `${d.userName} -  ${d.totalActivities} Activities`)
          .attr("x", -150)
          .attr("dy", -8)
          .attr("y", (d, i) => -(i + 1) * 25);

      g.attr("transform", "translate(200,300)");
    },
    generate2xchart() {

    }
  },
};
</script>

<style>
.analtics{
  display: block;
  width:100%;
  height: 40px;
  font-size: 26px;
}

.analtics span{
  color: orangered;
}

.analtics label{
  color: black;
  width: 80%;
}

</style>
