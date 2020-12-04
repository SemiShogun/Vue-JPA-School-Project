import { Continent } from "./Continent";
import { Infected } from "./Infected";

export interface Country {
    id?: number;
    countryName: string;
    continent?: Continent;
    infections?: Array<Infected>;
}
