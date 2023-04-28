import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { UserListComponent } from '../user-list/user-list.component';
import {AppRoutingModule} from "./app-routing.module";
import {PersonService} from "../../services/person.service";
import {StatisticsService} from "../../services/statistics.service";
import { OldestComponent } from '../oldest/oldest.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    OldestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    RouterModule.forRoot([]),
    HttpClientModule,
    FormsModule
  ],
  providers: [PersonService, StatisticsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
