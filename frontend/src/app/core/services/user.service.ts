import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/public/model/user';
import { environment } from 'src/environments/environment';
import { JwtRequest } from '../../public/model/jwtRequest';
import { UserAuthService } from '../auth/user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  requestHeader = new HttpHeaders(
    { "No-Auth": "true" }
  );

  constructor(private http: HttpClient, private userAuthService: UserAuthService) { }

  // Method to authenticate User
  public login(loginData: JwtRequest) {
    return this.http.post<JwtRequest>(environment.userAuthenticateUrl, loginData, { headers: this.requestHeader });
  }

  // Method to add User
  public signUp(signUpData: User) {
    return this.http.post<User>(environment.addUserUrl, signUpData, { headers: this.requestHeader });
  }

  // Method to match the role of the user
  public roleMatch(allowedRoles: any): boolean {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();
    if (userRoles != null && userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowedRoles.length; j++) {
          if (userRoles[i].roleName === allowedRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }
    return isMatch
  }

  // Method to get User By Id
  getUserById(id: any): Observable<User> {
    return this.http.get<User>(`${environment.getUserUrl}${id}`);
  }

  // Method to delete User
  deleteUser(id: string): Observable<User> {
    return this.http.delete<User>(`${environment.deleteUserUrl}${id}`);
  }

  // Method to update user
  updateUser(user: User, id: string): Observable<User> {
    return this.http.put<User>(`${environment.updateUserUrl}${id}`, user);
  }

  // Method to get ALl user
  getAllUser(): Observable<User[]> {
    return this.http.get<User[]>(`${environment.getAllUsersUrl}`);
  }
}
