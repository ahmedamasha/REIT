import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: "/",
            alias: "/home",
            name: "homepage",
            component: () => import("./components/HomePage")
        },
        {
            path: "/activities",
            alias: "/activities",
            name: "activities",
            component: () => import("./components/ActivitiesList")
        },
        {
            path: "/activities/user/:id",
            name: "activities-user",
            component: () => import("./components/UserList")
        }, {
            path: "/activities/building/:id",
            name: "activities-building",
            component: () => import("./components/BulidingList")
        }
    ]
});
