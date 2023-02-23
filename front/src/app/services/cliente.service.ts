import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService{

  private baseURL = 'http://localhost:8011'
  headers= new HttpHeaders().set('content-type', 'application/json').set('Access-Control-Allow-Origin', '*')

  constructor(
    private httpClient:HttpClient
    ) { }

  public getAllCliente():Observable<any>{
    return this.httpClient.get(this.baseURL +'/cliente/all', { 'headers':  this.headers})
  }

  public getClientebyId(id:number):Observable<any>{
    return this.httpClient.get(this.baseURL+'/cliente/'+id, { 'headers':  this.headers})
  }

  public saveClient(client:any):Observable<any>{
    return this.httpClient.post(this.baseURL+'/cliente', client, {'headers':  this.headers})
  }

  public deleteClientebyId(id:number):Observable<any>{
    return this.httpClient.delete(this.baseURL+'/cliente/'+id, { 'headers':  this.headers})
  }
}
