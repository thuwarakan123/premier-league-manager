import { Component, OnInit } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { FootballClub } from '../Model/FootballClub';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-win-club-score',
  templateUrl: './win-club-score.component.html',
  styleUrls: ['./win-club-score.component.css']
})
export class WinClubScoreComponent implements OnInit {

  Clubs : FootballClub[] = [];
  

  private httpClient: HttpClient;
  private URL = "http://localhost:9000/scoreClub"; 
   
   
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


}
