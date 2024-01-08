import { Component, OnInit, ViewChild } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { FootballClub } from '../Model/FootballClub';
import { Observable } from 'rxjs';
   


@Component({
  selector: 'app-club-table',
  templateUrl: './club-table.component.html',
  styleUrls: ['./club-table.component.css']
})
export class ClubTableComponent implements OnInit {

  Clubs : FootballClub[] = [];
  

  private httpClient: HttpClient;
  private URL = "http://localhost:9000/clubs"; 
   
   
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
 
