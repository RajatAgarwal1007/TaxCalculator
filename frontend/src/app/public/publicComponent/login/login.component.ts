import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtRequest } from '../../model/jwtRequest';
import { UserAuthService } from '../../../core/auth/user-auth.service';
import { UserService } from '../../../core/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService,
    private useAuthService: UserAuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  login(loginForm: JwtRequest) {
    this.userService.login(loginForm).subscribe(
      (response: any) => {
        localStorage.setItem('userName', JSON.stringify(response.user.userName));
        localStorage.setItem('userFirstName', JSON.stringify(response.user.userFirstName));
        localStorage.setItem('userLastName', JSON.stringify(response.user.userLastName));
        this.useAuthService.setRoles(response.user.role);
        this.useAuthService.setToken(response.jwtToken);
        const role = response.user.role[0].roleName;
        console.log(response)
        console.log(localStorage.getItem('userFirstName'))
        if (role == "Admin") {
          this.router.navigate(['/adminDashboard']);
        } else {
          this.router.navigate(['/userDashboard'])
        }
      },
      (err) => {
        console.log(err);
      }
    )

  }

}
