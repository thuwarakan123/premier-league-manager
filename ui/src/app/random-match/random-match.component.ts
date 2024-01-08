import { Component, OnInit } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { FootballClub } from '../Model/FootballClub';
import { Observable } from 'rxjs';
import { Match } from '../Model/Match';
import { Date } from '../Model/Date';
 

@Component({
  selector: 'app-random-match',
  templateUrl: './random-match.component.html',
  styleUrls: ['./random-match.component.css']
})
export class RandomMatchComponent implements OnInit {

  Clubs : FootballClub[] = [];
  //match:any;
  day:number;
  month:number;
  year:number;
  Date:string;
  Goal1:number;
  Goal2:number;
  Club1 : FootballClub;
  Club2 : FootballClub;
  count1 : number;
  count2 : number;


  private httpClient: HttpClient;
  private URL = "http://localhost:9000/clubs";  
  //private URL = "http://localhost:9000/random";
  
   
   
    constructor (httpClient: HttpClient) {
      this.httpClient = httpClient;
         
    }
    ngOnInit() {
      this.getList();
      
    }

    getlistlist():Observable<FootballClub[]>{
      return this.httpClient.get<FootballClub[]>(`${this.URL}`) 
  
    }

    getList(){
      this.getlistlist().subscribe((data:FootballClub[])=>{
        console.log(data);
        this.Clubs=data;   
      });
  
    }
    
    RandomMatch(){
      this.day = Math.floor(Math.random() * (27 + 1)) + 1;
      this.month = Math.floor(Math.random() * (11 + 1)) + 1;
      this.year = 2020;
      this.Goal1 = Math.floor(Math.random() * (9 + 1)) + 1;
      this.Goal2 = Math.floor(Math.random() * (9 + 1)) + 1;
      this.Date = this.day+"/"+this.month+"/"+this.year;
      this.count1 = Math.floor(Math.random() * (this.Clubs.length)) ;
      this.count2 = Math.floor(Math.random() * (this.Clubs.length)) ;
      while(this.count1 == this.count2){
        this.count2 = Math.floor(Math.random() * (this.Clubs.length)) ;
      }
      this.Club2 = this.Clubs[this.count2];
      this.Club1 = this.Clubs[this.count1];
       

      document.getElementById("Goal1").innerHTML = "First team Goal : "+ this.Goal1;
      document.getElementById("Goal2").innerHTML = "Sceond team Goal : "+ this.Goal2;
      document.getElementById("date").innerHTML = "Date : "+ this.Date; 
      document.getElementById("Club1").innerHTML = "First team : "+ this.Club1.name;
      document.getElementById("Club2").innerHTML = "Sceond team : "+ this.Club2.name;

      // document.getElementById("Goal1").innerHTML = "First team Goal : "+  this.match.club2Goal;
      // document.getElementById("Goal2").innerHTML = "Sceond team Goal : "+ this.match.club1Goal;
      // document.getElementById("date").innerHTML = "Date : "+ this.match.stringDate; 
      // document.getElementById("Club1").innerHTML = "First team : "+ this.match.club1Name;
      // document.getElementById("Club2").innerHTML = "Sceond team : "+ this.match.club2Name;
      
      let match = new Match();
      
      let date = new Date();
      date.day = this.day;
      date.month = this.month;
      date.year = this.year;

      match.club1 = this.Club1;
      match.club2 = this.Club2;
      match.club1Goal = this.Goal1;
      match.club2Goal = this.Goal2;
      match.matchDate = date;
      match.stringDate = this.Date;
      match.club1Name = this.Club1.name;
      match.club2Name = this.Club2.name;   

    }
}
