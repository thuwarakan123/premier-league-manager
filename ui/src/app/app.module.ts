import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClubTableComponent } from './club-table/club-table.component';
import { HttpClientModule } from '@angular/common/http';
import { MatchTableComponent } from './match-table/match-table.component';
import { WinClubTableComponent } from './win-club-table/win-club-table.component';
import { WinClubScoreComponent } from './win-club-score/win-club-score.component';
import { RandomMatchComponent } from './random-match/random-match.component';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
 

@NgModule({
  declarations: [
    AppComponent,
    ClubTableComponent,
    MatchTableComponent,
    WinClubTableComponent,
    WinClubScoreComponent,
    RandomMatchComponent,
     
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
