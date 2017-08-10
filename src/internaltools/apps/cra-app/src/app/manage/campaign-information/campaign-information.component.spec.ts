import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CampaignInformationComponent } from './campaign-information.component';

describe('CampaignInformationComponent', () => {
  let component: CampaignInformationComponent;
  let fixture: ComponentFixture<CampaignInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CampaignInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CampaignInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
