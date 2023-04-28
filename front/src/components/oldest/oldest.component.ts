import {Component, OnInit} from '@angular/core';
import {PersonService} from "../../services/person.service";

@Component({
  selector: 'app-oldest',
  templateUrl: './oldest.component.html',
  styleUrls: ['./oldest.component.css']
})
export class OldestComponent implements OnInit{
  name: string = '';
  constructor(private service: PersonService) {
  }

  ngOnInit(): void {
    this.service.getOldestName().subscribe(data=>{
      this.name = data.name;
    })
  }
}
