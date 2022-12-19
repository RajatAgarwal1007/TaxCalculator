import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from 'src/app/core/auth/user-auth.service';
import { UserService } from 'src/app/core/services/user.service';
import { JwtRequest } from '../../model/jwtRequest';
import { User } from '../../model/user';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  loginUser: JwtRequest = new JwtRequest();

  constructor(private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  signUp(formValue: User) {
    // if (this.userService.getUserById(formValue.userName) != null) {
    //   alert("User Name is Already Taken");
    // } else {
      this.loginUser.userName = formValue.userName;
      this.loginUser.userPassword = formValue.userPassword;
      this.userService.signUp(formValue).subscribe(
        (response: any) => {
          console.log(response)
          this.login(this.loginUser)
        },
        (err) => {
          console.log(err);
        }
      )
    // }

  }

  login(loginUser: any) {
    this.userService.login(loginUser).subscribe(
      (response: any) => {
        localStorage.setItem('userName', JSON.stringify(response.user.userName));
        localStorage.setItem('userFirstName', JSON.stringify(response.user.userFirstName));
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);
        // const role = response.user.role[0].roleName;
        console.log(response)
        console.log(localStorage.getItem('userFirstName'))
        // if (role == "Admin") {
        //   this.router.navigate(['/adminDashboard']);
        // } else {
        this.router.navigate(['/userDashboard'])
        // }
      },
      (err) => {
        console.log(err);
      }
    )

  }

}
