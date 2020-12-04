<template>
  <div class="create">
      <h1>This is a create form.</h1>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import Axios from "axios";

@Component
export default class CreateCountry extends Vue {
  private url = "localhost:8080";
  private

  async createCountry() {
    await Axios.post("")
  }

  mounted() {
      console.log("Wassup");
  }
}
</script>
