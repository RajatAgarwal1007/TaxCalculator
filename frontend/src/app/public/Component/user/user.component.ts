import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../core/services/user.service';
import { User } from '../../model/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userName: string | undefined;
  userFirstName: string | undefined;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUser();
  }

  // Get UserInfo from the local Storage that was set during login
  getUser() {
    this.userName = localStorage.getItem('userName') || "";
    this.userFirstName = localStorage.getItem('userFirstName') || "";
  }

}
