import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  userName: string | undefined;
  userFirstName: string | undefined;

  constructor() { }

  ngOnInit(): void {
    this.getUser();
  }

  // Get UserInfo from the local Storage that was set during login
  getUser() {
    this.userName = localStorage.getItem('userName') || "";
    this.userFirstName = localStorage.getItem('userFirstName') || "";
  }

}
