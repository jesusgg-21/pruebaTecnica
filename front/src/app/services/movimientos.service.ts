import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovimientosService{

  private baseURL = 'http://localhost:8013'
  headers= new HttpHeaders().set('content-type', 'application/json').set('Access-Control-Allow-Origin', '*')

  constructor(
    private httpClient:HttpClient
    ) { }

  public getAllMovimiento():Observable<any>{
    return this.httpClient.get(this.baseURL +'/movimiento/all', { 'headers':  this.headers})
  }

  public getMovimientobyId(id:number):Observable<any>{
    return this.httpClient.get(this.baseURL+'/movimiento/'+id, { 'headers':  this.headers})
  }

  public saveMovimiento(client:any):Observable<any>{
    return this.httpClient.post(this.baseURL+'/movimiento', client, {'headers':  this.headers})
  }

  public deleteMovimientobyId(id:number):Observable<any>{
    return this.httpClient.delete(this.baseURL+'/movimiento/'+id, { 'headers':  this.headers})
  }
}