import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OldestComponent } from './oldest.component';

describe('OldestComponent', () => {
  let component: OldestComponent;
  let fixture: ComponentFixture<OldestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OldestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OldestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
