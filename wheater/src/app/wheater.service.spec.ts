import { TestBed, inject } from '@angular/core/testing';

import { WheaterService } from './wheater.service';

describe('WheaterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [WheaterService]
    });
  });

  it('should be created', inject([WheaterService], (service: WheaterService) => {
    expect(service).toBeTruthy();
  }));
});
