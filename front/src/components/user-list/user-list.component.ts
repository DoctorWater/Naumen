import {Component, OnInit} from '@angular/core';
import {StatisticsService} from "../../services/statistics.service";
import {UserListDto} from "../../dto/user-list-dto";
import {UserFrequency} from "../../model/user-frequency";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: UserFrequency[] = [];

  constructor(private userService: StatisticsService) {

  }

  ngOnInit(): void {
    this.userService.getFrequencyHashmap().subscribe(data => {
      let userNames: string[] = data.names;
      let userFrequencies: string[] = data.frequencies;
      for (let i=0; i<data.names.length;i++){
        this.users.push(new UserFrequency(userNames[i], userFrequencies[i]))
      }
    })
  }
}
