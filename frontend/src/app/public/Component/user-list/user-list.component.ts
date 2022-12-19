import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/core/services/user.service';
import { User } from '../../model/user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: User[] | undefined;
  formValue !: FormGroup;
  userModelObject: User = new User();
  showAdd !: boolean;
  shoeUpdate !: boolean;


  constructor(public userService: UserService,
    private formbuilder: FormBuilder) { }

  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      userName: [''],
      userFirstName: [''],
      userLastName: ['']
    })

    this.getAllUser();
  }

  // Getting ALl Users
  getAllUser() {
    this.userService.getAllUser().subscribe((data: User[]) => {
      this.users = data;
    })

  }

  // deleting User by Id
  deleteUser(user: User) {
    this.userService.deleteUser(user.userName).subscribe(() => {
      this.getAllUser();
      alert(user.userFirstName + " is deleted successfully");
    })
  }

  // On clicking Edit Button
  onEdit(user: User) {
    this.formValue.controls[`userName`].setValue(user.userName);
    this.formValue.controls[`userFirstName`].setValue(user.userFirstName);
    this.formValue.controls[`userLastName`].setValue(user.userLastName);
  }

  // update Tax method
  updateUser() {
    this.userModelObject.userName = this.formValue.value.userName;
    this.userModelObject.userFirstName = this.formValue.value.userFirstName;
    this.userModelObject.userLastName = this.formValue.value.userLastName;
    this.userService.updateUser(this.userModelObject, this.userModelObject.userName)
      .subscribe(res => {
        alert("Update Successfully");
        let ref = document.getElementById('cancel');
        ref?.click();
        this.formValue.reset();
        this.getAllUser();
      })
  }
}

