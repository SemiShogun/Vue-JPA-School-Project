<template>
  <div class="list">
    <h1>Continents</h1>
    <ul>
      <li v-for="(continent, index) in continents" :key="index">
        {{ index }}. Name: {{ continent.continentName }}
        <a href="#">
          <button type="button" class="btn btn-primary">Update</button>
        </a>
        <button
          type="button"
          class="btn btn-primary"
          @click="deleteContinent(continent.id)"
        >
          Delete
        </button>
        <br />
        <b>Countries:</b>
        <p
          v-for="(country, index) in continent.countries"
          :key="index"
          style="margin: 0"
        >
          {{ country.countryName }}
        </p>
      </li>
    </ul>
    <h1>Countries</h1>
    <ul>
      <li v-for="(country, index) in countries" :key="index">
        {{ index }}. country: {{ country.countryName }}
        <button
          type="button"
          class="btn btn-primary"
          @click="deleteCountry(country.id)"
        >
          Delete
        </button>
        <br />
        <b>infections:</b>
        <p
          v-for="(infection, index) in country.infections"
          :key="index"
          style="margin: 0"
        >
          {{ infection.name }}
        </p>
      </li>
    </ul>
    <h1>Infected</h1>
    <ul>
      <li v-for="(infected, index) in infecteds" :key="index">
        {{ index }}. Name: {{ infected.name }}
        <button
          type="button"
          class="btn btn-primary"
          @click="deleteInfected(infected.id)"
        >
          Delete
        </button>
      </li>
    </ul>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { Infected } from "../interfaces/Infected";
import { Continent } from "../interfaces/Continent";
import { Country } from "../interfaces/Country";
import Axios from "axios";

@Component
export default class List extends Vue {
  private infecteds: Array<Infected> = [];
  private continents: Array<Continent> = [];
  private countries: Array<Country> = [];
  private url = "http://localhost:8080";

  async retrieveInfected() {
    // Insert axios.get request for retrieving all infected
    await Axios.get(`${this.url}/infected`)
      .then((res) => {
        console.log(res);
        this.infecteds = res.data;
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
      })
      .catch((e) => {
        console.log(e);
      });
  }

  async retrieveContinents() {
    await Axios.get(`${this.url}/continent`)
      .then((res) => {
        console.log(res.data);
        this.continents = res.data;
      })
      .catch((e) => {
        console.log(e);
      });
  }

  async deleteContinent(id: number) {
    await Axios.delete(`${this.url}/continent/${id}`)
      .then((res) => {
        this.retrieveContinents();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  async deleteCountry(id: number) {
    await Axios.delete(`${this.url}/country/${id}`)
      .then((res) => {
        this.retrieveCountries();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  async deleteInfected(id: number) {
    await Axios.delete(`${this.url}/infected/${id}`)
      .then((res) => {
        this.retrieveInfected();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  mounted() {
    this.retrieveInfected();
    this.retrieveCountries();
    this.retrieveContinents();
  }
}
</script>
