import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Observable} from "rxjs";
import {AgeDto} from "../dto/age-dto";
import {NameDto} from "../dto/name-dto";

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private personUrl: string;

  constructor(private httpClient: HttpClient) {
    this.personUrl = 'http://localhost:8080/people';
  }

  public getAgeByName(name: string): Observable<AgeDto> {
    let result: Observable<AgeDto>;
    result = this.httpClient.get<AgeDto>(this.personUrl.concat('/get-age-by-name/').concat(name));
    return result;
  }

  public getOldestName(): Observable<NameDto>{
    return this.httpClient.get<NameDto>(this.personUrl.concat('/highest-age'));
  }
}
