import {Component} from '@angular/core';
import {PersonService} from '../../services/person.service'
import {Observable} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent {
  title: string;
  name: string;
  age: number;

  constructor(private personService: PersonService) {
    this.title = 'Naumen Test Project';
    this.name = ' ';
    this.age = 0;
  }

  getAgeByName(): void {
    this.personService.getAgeByName(this.name).subscribe(data => this.age = data.age);
  }
}
