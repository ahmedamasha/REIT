<template>
  <div class="container">
    <div class="col-md-12">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Search by activityName"
               @input="searchTitle" v-model="title"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
                  @click="searchTitle">Search
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-12">

      <div class="alert alert-primary" role="alert">
        HINT : Press on the user name or Building name to list all Activities related to it ...
      </div>
      <table class="table table-hover">
        <thead>
        <tr>
          <th>#TaskId</th>
          <th>Activity Name</th>
          <th>Building Name , Status</th>
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
            <router-link :to="'/activities/building/' + activity.building.id" class="btn  btn_progress  badge-warning">
              {{ activity.building.name }}
            </router-link>

            <div class="btn status" :style="{'background-color':activity.building.status.color  }"> {{
                activity.building.status.name
              }}
            </div>

          </td>
          <td>
            <router-link :to="'/activities/user/' + activity.user.id" class="btn btn_progress  badge-warning">
              {{ activity.user.name }}
            </router-link>

            <div class="btn  btn_progress  status" :style="{'background-color':activity.status.color  }"> {{
                activity.status.name
              }}
            </div>

          </td>

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
      title: ""
    };
  },
  methods: {
    retrieveActivities() {
      ActivityDataService.getAll()
          .then(response => {
            console.log(response.data);
            this.activities = response.data;
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
    this.retrieveActivities();
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
