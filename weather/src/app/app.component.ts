import { Component } from '@angular/core';
import { WheaterService } from './wheater.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [WheaterService]
})
export class AppComponent {
  constructor(private wheaterService: WheaterService) {

  }

  title = 'Weather';
  city = '';
  wheater: any;
  error: any;

  onSearchHandler() {
    this.wheaterService.getWheater(this.city)
      .subscribe((response) => {
        this.wheater = { ...response };
      }, (error) => {
        this.error = error.error;
      });
  }
}
