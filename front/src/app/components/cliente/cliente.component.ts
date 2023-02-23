import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/services/cliente.service';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit{

  clientes?: any
  searchText: any;

  constructor(
    private serviceCli: ClienteService,
    private servicePer: PersonaService,
    ){}

  ngOnInit(): void {
    
    this.serviceCli.getAllCliente().subscribe(cli => {
      this.clientes = cli
      for(let cl of this.clientes ){
        this.servicePer.getPresonabyId(cl.personaId).subscribe(per=>{
          cl.nombre = per.nombre
          cl.direccion = per.direccion
          cl.telefono = per.telefono
        })
      }
      
    })
    
  }

}
