import { TestBed } from '@angular/core/testing';

import { IRCService } from './irc.service';

describe('IRCService', () => {
  let service: IRCService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IRCService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
