import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { TaxService } from '../../services/tax.service';
import { StateService } from '../../services/state.service';
import { ZoneService } from '../../services/zone.service';
import { Tax } from '../../model/Tax';
import { State } from '../../model/State';
import { Zone } from '../../model/Zone';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-calculated-tax',
  templateUrl: './calculated-tax.component.html',
  styleUrls: ['./calculated-tax.component.css'],
})
export class CalculatedTaxComponent implements OnInit {
  taxes: Tax[] | undefined;
  formValue!: FormGroup;
  taxModelObject: Tax = new Tax();
  showAdd!: boolean;
  showUpdate!: boolean;
  states: State[] | undefined;
  zones: Zone[] | undefined;

  constructor(
    private taxService: TaxService,
    private stateService: StateService,
    private zoneService: ZoneService,
    private formbuilder: FormBuilder,
    public userService: UserService
  ) {}

  ngOnInit(): void {
    this.getAllTax();

    this.formValue = this.formbuilder.group({
      userName: [''],
      phone: [''],
      email: [''],
      amount: [''],
      stateId: [''],
      zoneId: [''],
    });

    // State dropDown
    this.stateService.getAllStates().subscribe((data: State[]) => {
      this.states = data;
    });

    // Zone dropDown
    this.zoneService.getAllZones().subscribe((data: Zone[]) => {
      this.zones = data;
    });
  }

  // Getting all  Tax
  getAllTax() {
    this.taxService.getAllTaxes().subscribe((data: Tax[]) => {
      this.taxes = data;
    });
  }

  // Deleting Tax by Id
  deleteTax(tax: Tax) {
    this.taxService.deleteTax(tax.id).subscribe(() => {
      this.getAllTax();
      alert(tax.user.userName + ' Tax is deleted successfully');
    });
  }

  // On clicking the OnEdit Button the Value are already filled
  onEdit(tax: Tax) {
    this.taxModelObject.id = tax.id;
    this.formValue.controls[`name`].setValue(tax.user.userName);
    // this.formValue.controls[`phone`].setValue(tax.user.phone);
    // this.formValue.controls[`email`].setValue(tax.user.email);
    this.formValue.controls[`amount`].setValue(tax.amount);
    this.formValue.controls[`stateId`].setValue(tax.stateId);
    this.formValue.controls[`zoneId`].setValue(tax.zoneId);
  }

  // Update Tax method
  updateTax() {
    this.taxModelObject.user.userName = this.formValue.value.name;
    // this.taxModelObject.user.phone = this.formValue.value.phone;
    // this.taxModelObject.user.email = this.formValue.value.email;
    this.taxModelObject.amount = this.formValue.value.amount;
    this.taxModelObject.stateId = this.formValue.value.stateId;
    this.taxModelObject.zoneId = this.formValue.value.zoneId;
    this.taxService
      .updateTax(this.taxModelObject, this.taxModelObject.id)
      .subscribe((res) => {
        alert('update Successfully');
        let ref = document.getElementById('cancel');
        ref?.click();
        this.formValue.reset();
        this.getAllTax();
      });
  }
}
