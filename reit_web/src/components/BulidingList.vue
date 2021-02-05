<template>
  <div class="container">
    <div class="col-md-12">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by activityName"
               @input="searchTitle" v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
                  @click="searchTitle"
          >
            Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-12">
      <h3 style="font-size: 23px;
                  display: block;
                  margin-bottom: 35px;
                  margin-top: 30px;">
        Here's the building Projects (Activities) : <span style="color:orangered">{{ headlineName }}</span> & Building Status : <span style="background-color:{ headlineColor}">{{ headlineStatus }}</span>
      </h3>
      <table class="table table-hover">
        <thead>
        <tr>
          <th>#</th>
          <th>Activity Name</th>
          <th>Assigned_to </th>
          <th>Activity Status</th>
        </tr>
        </thead>
        <tbody>
        <tr
            :class="{ active: index == currentIndex }"
            v-for="(activity, index) in activities"
            :key="index"
            @click="setActiveActivity(activity, index)"
        >
          <td>{{ activity.id }}</td>
          <td>{{ activity.activityName }}</td>
          <td>
            <router-link :to="'/activities/user/' + activity.user.id" class="badge badge-warning">
              {{ activity.user.name }}
            </router-link>

          </td>

          <td>
            <div class="btn status" :style="{'background-color':activity.status.color  }"> {{
                activity.status.name
              }}
            </div>

<!--            <router-link :to="'/activities/building/' + activity.building.id" class="btn badge-warning">-->
<!--              {{ activity.building.name }}-->
<!--            </router-link>-->

<!--            <div class="btn status" :style="{'background-color':activity.building.status.color  }"> {{-->
<!--                activity.building.status.name-->
<!--              }}-->
<!--            </div>-->

          </td>

          <td>
        </tr>
        </tbody>
      </table>

    </div>
  </div>
</template>

<script>
import ActivityDataService from "../services/ActivityDataService";

export default {
  name: "Activities-list",
  data() {
    return {
      activities: [],
      currentActivity: null,
      currentIndex: -1,
      title: "",
      headlineName: "",
      headlineStatus: "",
      headlineColor: ""
    };
  },
  methods: {
    retrieveActivities(id) {
      ActivityDataService.findByBuilding(id)
          .then(response => {
            console.log(response.data);
            this.activities = response.data;
            this.headlineStatus = response.data[0].building.status.name;
            this.headlineColor= response.data[0].building.status.color;
          })
          .catch(e => {
            console.log(e);
          });
    },

    refreshList() {
      this.retrieveActivities();
      this.currentActivity = null;
      this.currentIndex = -1;
    },

    setActiveActivity(activity, index) {
      this.currentActivity = activity;
      this.currentIndex = index;
    },

    searchTitle() {
      ActivityDataService.findByTitle(this.title)
          .then(response => {
            this.activities = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
    this.retrieveActivities(this.$route.params.id);
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}

.list-group-item.active {
  background-color: #fff;
  border-color: #afafaf;
  color: #000;
}
</style>
