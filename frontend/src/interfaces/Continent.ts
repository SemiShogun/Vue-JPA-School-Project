import { Country } from "./Country";

export interface Continent {
  id: number;
  continentName?: string;
  countries?: Array<Country>;
}
