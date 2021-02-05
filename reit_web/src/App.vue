<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <img  style="width: 134px; height: 47px;" src="../public/logo.svg" alt="Kiwi standing on oval">
      <router-link to="/" class="navbar-brand">Golden Real Estate</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/home" class="nav-link">Home Page</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/activities" class="nav-link">Activities [projects]</router-link>
        </li>
      </div>
    </nav>

    <div class="container mt-3">
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>
