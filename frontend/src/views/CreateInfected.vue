<template>
  <div class="createinfected">
    <h1>Create an infected person</h1>
    Name: <input type="text" v-model="name" />
    SurName: <input type="text" v-model="surName" />
    Age: <input type="number" v-model="age" />
    <br/>
    <button type="button" class="btn btn-primary" @click="createInfected()">
      Save changes
    </button>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import Axios from "axios";
import { Infected } from "../interfaces/Infected";
import { Country } from "../interfaces/Country";

@Component
export default class CreateInfected extends Vue {
  private url = "http://localhost:8080";
  private name: string;
  private surName: string;
  private age: number;
  private countries: Array<Country> = [];
  private selectedCountry: Country;

  async createInfected() {
    console.log(this.name);
    console.log(this.surName);
    console.log(this.age);
    const infected: Infected = {
      name: this.name,
      surName: this.surName,
      age: this.age,
      country: this.selectedCountry,
    };
    await Axios.post(`${this.url}/infected`, infected)
      .then((res) => {
        console.log(res.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  async retrieveCountries() {
    await Axios.get(`${this.url}/country`)
      .then((res) => {
        console.log(res);
        this.countries = res.data;
        this.selectedCountry = this.countries[1];
      })
      .catch((e) => {
        console.log(e);
      });
  }

  mounted() {
    this.retrieveCountries();
  }
}
</script>
