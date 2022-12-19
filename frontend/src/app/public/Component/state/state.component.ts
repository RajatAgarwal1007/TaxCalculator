import { HttpErrorResponse } from '@angular/common/http';
import { Statement } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/core/services/user.service';
import { State } from '../../model/State';
import { StateService } from '../../services/state.service';


// export class State {
//   id: number = 0;
//   name: string = "";
//   taxPercentage: number = 0;
// }

@Component({
  selector: 'app-state',
  templateUrl: './state.component.html',
  styleUrls: ['./state.component.css']
})
export class StateComponent implements OnInit {

  states: State[] | undefined;
  stateModelObject: State = new State();
  formValue !: FormGroup
  showAdd !: boolean;
  showUpdate !: boolean;
  present !: boolean;

  constructor(private stateService: StateService,
    private formbuilder: FormBuilder,
    public userService: UserService) { }

  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      name: [''],
      taxPercentage: ['']
    })

    this.getAllState();


  }

  // Getting all State
  getAllState() {
    this.stateService.getAllStates().subscribe((data: State[]) => {
      this.states = data;
    })
  }

  // On Clicking Add Button only Add button should show
  clickAddState() {
    this.formValue.reset();
    this.showAdd = true;
    this.showUpdate = false;
  }

  // Add Model for Adding State Details
  postStateDetails() {
    this.stateModelObject.name = this.formValue.value.name;
    this.stateModelObject.taxPercentage = this.formValue.value.taxPercentage;
    this.stateService.getStateById(this.formValue.value.id).subscribe(data => {
      if(data == null) {
        this.present = false;
      } else {
        this.present = true;
      }
    })
    if (this.present) {
      alert("State Already Exist");
    } else {

      this.stateService.addState(this.stateModelObject).subscribe(res => {
        console.log(res);
        alert("State Added Successfully")
        let ref = document.getElementById('cancel');
        ref?.click();
        this.formValue.reset();
        this.getAllState();
      },
        err => {
          alert("Something went wrong")
        })
    }
  }

  //Deleting state By id
  deleteState(state: State) {
    this.stateService.delete(state.id).subscribe(() => {
      this.getAllState();
      alert(state.name + " State is deleted suceessfully");
    })
  }

  //On Clicking Edit Button Edit Model should show
  onEdit(state: State) {
    this.showAdd = false;
    this.showUpdate = true;
    this.stateModelObject.id = state.id;
    this.formValue.controls[`name`].setValue(state.name);
    this.formValue.controls[`taxPercentage`].setValue(state.taxPercentage);
  }

  //Update Zone Model
  updateState() {
    this.stateModelObject.name = this.formValue.value.name;
    this.stateModelObject.taxPercentage = this.formValue.value.taxPercentage;
    this.stateService.updateState(this.stateModelObject, this.stateModelObject.id)
      .subscribe(res => {
        alert("update Successfully");
        let ref = document.getElementById('cancel');
        ref?.click();
        this.formValue.reset();
        this.getAllState();
      })
  }
}