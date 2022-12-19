import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  // Method to set role the local storage
  public setRoles(roles: []) {
    localStorage.setItem('roles', JSON.stringify(roles));
  }

  // Method to get role from local storage
  public getRoles(): [] {
    return JSON.parse(localStorage.getItem('roles') || '{}');
  }

  // Method to set Token to local storage
  public setToken(jwtToken: string) {
    localStorage.setItem('jwtToken', jwtToken);
  }

  // Method to get Token from local storage
  public getToken(): string {
    return localStorage.getItem('jwtToken') || "";
  }

  // Method to clear localStorage
  public clear() {
    localStorage.clear();
  }

  // Method which return boolean weather user is logged in or not
  public isLoggedIn() {
    return this.getRoles() && this.getToken();
  }
}

