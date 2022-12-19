import { Component, OnInit } from '@angular/core';
import { ZoneService } from '../../services/zone.service';
import { FormBuilder, FormGroup } from '@angular/forms'
import { Zone } from '../../model/Zone';
import { UserService } from 'src/app/core/services/user.service';


@Component({
  selector: 'app-zone',
  templateUrl: './zone.component.html',
  styleUrls: ['./zone.component.css']
})
export class ZoneComponent implements OnInit {

  zones: Zone[] | undefined;
  formValue !: FormGroup;
  zoneModelObject: Zone = new Zone();
  showAdd !: boolean;
  showUpdate !: boolean;
  present !: boolean;

  constructor(private zoneService: ZoneService,
    private formbuilder: FormBuilder,
    public userService: UserService) { }

  ngOnInit(): void {
    // Initializing the formbuilder and grouping it and intializing the formValue
    this.formValue = this.formbuilder.group({
      name: [''],
      taxPercentage: ['']
    })

    this.getAllZone();
  }


  // Getting all zone 
  getAllZone() {
    this.zoneService.getAllZones().subscribe((data: Zone[]) => {
      this.zones = data;
    });
  }


  // On Clicking Add Button only Add button should show
  clickAddZone() {
    this.formValue.reset();
    this.showAdd = true;
    this.showUpdate = false;
  }

  // Add Model for adding Zone Details
  postZoneDetails() {
    this.zoneModelObject.name = this.formValue.value.name;
    this.zoneModelObject.taxPercentage = this.formValue.value.taxPercentage;
    this.zoneService.getZoneByName(this.formValue.value.name).subscribe(data => {
      if (data == null) {
        this.present = false;
      } else {
        this.present = true;
      }
    })

    if (this.present) {
      alert("Zone Already Exist");
    } else {

      this.zoneService.addZone(this.zoneModelObject).subscribe(res => {
        console.log(res);
        alert("Zone Added Successfully")
        let ref = document.getElementById('cancel')
        ref?.click();
        this.formValue.reset();
        this.getAllZone();

      },
        err => {
          alert("Something went wrong")
        }
      )

    }
  }


  //Deleting zone by Id
  deleteZone(zone: Zone) {
    this.zoneService.deleteZone(zone.id).subscribe(() => {
      this.getAllZone();
      alert(zone.name + " Zone is deleted successfully");
    })
  }


  //On clicking Edit button Edit Model should show
  onEdit(zone: Zone) {
    this.showAdd = false;
    this.showUpdate = true;
    this.zoneModelObject.id = zone.id;
    this.formValue.controls[`name`].setValue(zone.name);
    this.formValue.controls[`taxPercentage`].setValue(zone.taxPercentage);
  }

  //update Zone method
  updateZone() {
    this.zoneModelObject.name = this.formValue.value.name;
    this.zoneModelObject.taxPercentage = this.formValue.value.taxPercentage;
    this.zoneService.updateZone(this.zoneModelObject, this.zoneModelObject.id)
      .subscribe(res => {
        alert("updated Successfully");
        let ref = document.getElementById('cancel')
        ref?.click();
        this.formValue.reset();
        this.getAllZone();
      })
  }
}
