import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WheaterService {

  constructor(private http: HttpClient) { }

  public getWheater(city: string) {
    return this.http.get(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=9c823f544a7c59bfc7a4a2c5055ced41`);
  }
}
