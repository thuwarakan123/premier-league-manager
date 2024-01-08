import { Date } from "./Date";
import { FootballClub } from "./FootballClub";

export class Match{
    club1 : FootballClub;
    club2 : FootballClub;
    club1Goal : number;
    club2Goal : number;
    matchDate : Date;
    club1Name : string;
    club2Name : string;
    stringDate : string;
}