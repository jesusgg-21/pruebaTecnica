import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService{

  private baseURL = 'http://localhost:8010'
  headers= new HttpHeaders().set('content-type', 'application/json').set('Access-Control-Allow-Origin', '*')

  constructor(
    private httpClient:HttpClient
    ) { }

  public getAllPresona():Observable<any>{
    return this.httpClient.get(this.baseURL +'/persona/all', { 'headers':  this.headers})
  }

  public getPresonabyId(id:number):Observable<any>{
    return this.httpClient.get(this.baseURL+'/persona/'+id, { 'headers':  this.headers})
  }

  public savePresona(client:any):Observable<any>{
    return this.httpClient.post(this.baseURL+'/persona', client, {'headers':  this.headers})
  }

  public deletePresonabyId(id:number):Observable<any>{
    return this.httpClient.delete(this.baseURL+'/persona/'+id, { 'headers':  this.headers})
  }

  public getPresonaUsuariobyId(id:number):Observable<any>{
    return this.httpClient.get(this.baseURL+'/persona/usuarios/'+id, { 'headers':  this.headers})
  }
}
