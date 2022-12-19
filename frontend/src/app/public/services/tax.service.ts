import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tax } from '../model/Tax';


@Injectable({
  providedIn: 'root'
})
export class TaxService {
  // private serverUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  // Method to send POSTrequest to add Tax to backend 
  addTax(tax: Tax): Observable<Tax> {
    // return this.http.post<Tax>(`${this.serverUrl}/tax/addTax`, tax);
    return this.http.post<Tax>(`${environment.addTaxUrl}`, tax);
  }

  // Method to send DELETErequest to delete tax from the backend
  deleteTax(id: number): Observable<Tax> {
    return this.http.delete<Tax>(`${environment.deleteTaxUrl}${id}`);
  }

  // Method to send PUTrequest to update Tax in backend
  updateTax(tax: Tax, id: number): Observable<Tax> {
    return this.http.put<Tax>(`${environment.updateTaxUrl}${id}`, tax);
  }

  // Method to send GETrequest to get tax by id from backend
  getTaxById(id: number): Observable<Tax> {
    return this.http.get<Tax>(`${environment.getTaxUrl}${id}`);
  }

  // Method to send GETrequest to get all tax from backend
  getAllTaxes(): Observable<Tax[]> {
    return this.http.get<Tax[]>(`${environment.getTaxesUrl}`);
  }
}
