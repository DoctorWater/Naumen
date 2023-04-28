import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserListDto} from "../dto/user-list-dto";

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  private personUrl: string;

  constructor(private httpClient: HttpClient) {
    this.personUrl = 'http://localhost:8080/statistics';
  }

  public getFrequencyHashmap(): Observable<UserListDto>{
    let result: Observable<UserListDto>;
    result = this.httpClient.get<UserListDto>(this.personUrl.concat('/frequency'));
    return result;
  }
}
