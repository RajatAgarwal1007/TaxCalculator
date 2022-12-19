import { Component, OnInit } from '@angular/core';
import { State } from '../../model/State';
import { Tax } from '../../model/Tax';

import { StateService } from '../../services/state.service';
import { Zone } from '../../model/Zone';
import { ZoneService } from '../../services/zone.service';
import { TaxService } from '../../services/tax.service';
import { User } from '../../model/user';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-tax',
  templateUrl: './tax.component.html',
  styleUrls: ['./tax.component.css'],
})
export class TaxComponent implements OnInit {
  tax: Tax | undefined;
  calculatedTax: number | undefined;
  states: State[] | undefined;
  zones: Zone[] | undefined;
  UserName: string | undefined;
  user: User = new User();

  constructor(
    private taxSerice: TaxService,
    private stateService: StateService,
    private zoneService: ZoneService,
    private userService: UserService
  ) {}

  ngOnInit() {
    // State dropDown
    this.stateService.getAllStates().subscribe((data: State[]) => {
      this.states = data;
    });

    // Zone dropDown
    this.zoneService.getAllZones().subscribe((data: Zone[]) => {
      this.zones = data;
    });
    this.setUser();
  }

  // This will get the name form the localStorage and set in a variable name as UserName
  setUser() {
    this.UserName = localStorage.getItem('userName')?.replace(/"/g, '');
    console.log(this.UserName);
    this.userService.getUserById(this.UserName).subscribe((data) => {
      this.user = data;
      console.log(this.user);
    });
  }

  // Geting Tax Information from the Form on UI
  getTaxFormData(tax: Tax) {
    this.userService.getUserById(this.UserName).subscribe((data) => {
      tax.user = data;
      console.log(this.user);
    });
    // tax.user = this.UserName;
    console.log(tax);
    this.taxSerice.addTax(tax).subscribe((result) => {
      this.calculatedTax = result.calculatedTax;
      this.tax = result;
    });
  }
}
