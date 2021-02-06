import http from "../http-common";

class ActivityDataService {
    getAll() {
        return http.get("/activities");
    }

    get(id) {
        return http.get(`/activities/${id}`);
    }

    findByTitle(title) {
        return http.get(`/activities?title=${title}`);
    }

    findByBuilding(BuldingId) {
        return http.get(`/activities/building/${BuldingId}`);
    }

    findByUser(userId) {
        return http.get(`/activities/user/${userId}`);
    }

    findByUsersActivity() {
        return http.get(`/user/activities`);
    }

    findByUsersCount() {
        return http.get(`/user/count`);
    }

    findByActivityCount() {
        return http.get(`/activities/count`);
    }

    findByBuildingCount() {
        return http.get(`/building/count`);
    }
}

export default new ActivityDataService();
