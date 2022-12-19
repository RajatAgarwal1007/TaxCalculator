import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Zone } from './../model/Zone';

@Injectable({
  providedIn: 'root'
})
export class ZoneService {
  // private serverUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  // Method to send POSTrequest to add Zone to backend 
  addZone(zone: Zone): Observable<Zone> {
    return this.http.post<Zone>(`${environment.addZoneUrl}`, zone);
  }

  // Method to send DELETErequest to delete Zone from the backend
  deleteZone(id: number): Observable<Zone> {
    return this.http.delete<Zone>(`${environment.deleteZoneUrl}${id}`);
  }

  // Method to send PUTrequest to update Zone in backend
  updateZone(zone: Zone, id: number): Observable<Zone> {
    return this.http.put<Zone>(`${environment.updateZoneUrl}${id}`, zone);
  }

  // Method to send GETrequest to get Zone by id from backend
  getZoneById(id: number): Observable<Zone> {
    return this.http.get<Zone>(`${environment.getZoneUrl}${id}`);
  }

  getZoneByName(name: string): Observable<Zone> {
    return this.http.get<Zone>(`${environment.getZoneByName}${name}`);
  }

  // Method to send GETrequest to get all Zone from backend
  getAllZones(): Observable<Zone[]> {
    return this.http.get<Zone[]>(`${environment.getZonesUrl}`);
  }
}
