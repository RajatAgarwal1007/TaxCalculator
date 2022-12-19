import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { State } from '../model/State';


@Injectable({
  providedIn: 'root'
})
export class StateService {

  constructor(private http: HttpClient) { }

  // Method to send POSTrequest to add State to backend 
  addState(state: State): Observable<State> {
    return this.http.post<State>(`${environment.addStateUrl}`, state);
  }

  // Method to send DELETErequest to delete State from the backend
  delete(id: number): Observable<State> {
    return this.http.delete<State>(`${environment.deleteStateUrl}${id}`);
  }

  // Method to send PUTrequest to update State in backend
  updateState(state: State, id: number): Observable<State> {
    return this.http.put<State>(`${environment.updateStateUrl}${id}`, state);
  }

  // Method to send GETrequest to get State by id from backend
  getStateById(id: number): Observable<State> {
    return this.http.get<State>(`${environment.getStateUrl}${id}`);
  }

  // Method to send GETrequest to get all State from backend
  getAllStates(): Observable<State[]> {
    return this.http.get<State[]>(`${environment.getStatesUrl}`);
  }
}
