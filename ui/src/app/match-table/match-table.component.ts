import { Component, OnInit } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Match } from '../Model/Match';

@Component({
  selector: 'app-match-table',
  templateUrl: './match-table.component.html',
  styleUrls: ['./match-table.component.css']
})
export class MatchTableComponent implements OnInit {
   

  Matches :Match[] = [];
  searchText;

  private httpClient: HttpClient;
  private URL = "http://localhost:9000/matches";
  day: number;
  month: number;
  year: number;
  Goal1: number;
   

  constructor (httpClient: HttpClient) {
    this.httpClient = httpClient;
       
  }
  ngOnInit() {
    this.getList();  
  }

  getlistlist():Observable<Match[]>{
    return this.httpClient.get<Match[]>(`${this.URL}`) 

  }

  getList(){
    this.getlistlist().subscribe((data:Match[])=>{
      console.log(data);
      this.Matches=data;   
    });

  }

   

  

   
}


