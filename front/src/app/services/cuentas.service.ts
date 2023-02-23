import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CuentasService{

  private baseURL = 'http://localhost:8012'
  headers= new HttpHeaders().set('content-type', 'application/json').set('Access-Control-Allow-Origin', '*')

  constructor(
    private httpClient:HttpClient
    ) { }

  public getAllCuenta():Observable<any>{
    return this.httpClient.get(this.baseURL +'/cuenta/all', { 'headers':  this.headers})
  }

  public getCuentabyId(id:number):Observable<any>{
    return this.httpClient.get(this.baseURL+'/cuenta/'+id, { 'headers':  this.headers})
  }

  public saveCuenta(cuenta:any):Observable<any>{
    return this.httpClient.post(this.baseURL+'/cuenta', cuenta, {'headers':  this.headers})
  }

  public deleteCuentabyId(id:number):Observable<any>{
    return this.httpClient.delete(this.baseURL+'/cuenta/'+id, { 'headers':  this.headers})
  }
}