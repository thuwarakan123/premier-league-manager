import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClubTableComponent } from './club-table/club-table.component';
import { MatchTableComponent } from './match-table/match-table.component';
import { RandomMatchComponent } from './random-match/random-match.component';
import { WinClubScoreComponent } from './win-club-score/win-club-score.component';
import { WinClubTableComponent } from './win-club-table/win-club-table.component';
 
 

const routes: Routes = [
{path:'clubtable', component:ClubTableComponent} ,
{path:"matchtable",component:MatchTableComponent},
{path:"Random", component:RandomMatchComponent},
{path:"clubbywin", component:WinClubTableComponent},
{path:"scoreclub",component:WinClubScoreComponent}
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
