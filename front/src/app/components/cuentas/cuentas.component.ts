import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ClienteService } from 'src/app/services/cliente.service';
import { CuentasService } from 'src/app/services/cuentas.service';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.css']
})
export class CuentasComponent {
  cuentas?: any
  clientes?: any
  clienteSelected?: any
  searchText: any;
  verFormulario:boolean = false
  numcuenta = Math.floor(Math.random()*1000000)

  cuentaForm = new FormGroup({
    numCuenta: new FormControl(),
    tipoCuenta: new FormControl(),
    saldoInicialCuenta: new FormControl(),
    estadoCuenta: new FormControl(),
    cliente: new FormControl()
  })

  constructor(
    private serviceCue: CuentasService,
    private serviceCli: ClienteService,
    private servicePer: PersonaService
    ){}

  ngOnInit(): void {
    this.llenarTabla()
    
  }

  llenarTabla(){
    try{
      this.serviceCue.getAllCuenta().subscribe(cue => {
        this.cuentas = cue
        for(let cl of this.cuentas ){
          this.serviceCli.getClientebyId(cl.cuentaId).subscribe(resp=>{
            cl.personaId = resp.personaId
            if (cl.personaId != undefined) {
              for(let cu of this.cuentas ){
                this.servicePer.getPresonabyId(cl.personaId).subscribe(resp=>{
                  cl.nombre = resp.nombre
                })
              }
            }
            console.log(cl)
          })
        }
      })
    }catch(error){
      console.error(error)
    }
  }

  verForm(): void{
    this.verFormulario = !this.verFormulario
    
    this.serviceCli.getAllCliente().subscribe(cli => {
      this.clientes = cli
      for(let cl of this.clientes ){
        this.servicePer.getPresonabyId(cl.personaId).subscribe(per=>{
          cl.nombre = per.nombre
        })
      }
      
    })
  }

  onSubmit() {
    console.log(this.cuentaForm)
    let newCuenta = {
      cuentaId:Math.random()*10,
      numeroCuenta:this.cuentaForm.value.numCuenta,
      tipoCuenta:this.cuentaForm.value.tipoCuenta,
      saldoInicial:parseFloat(this.cuentaForm.value.saldoInicialCuenta),
      estado:parseInt(this.cuentaForm.value.estadoCuenta),
      clienteID:parseInt(this.cuentaForm.value.cliente)
    }

    this.serviceCue.saveCuenta(newCuenta).subscribe( result => {
      if (result.cuentaId != null) {
        this.llenarTabla()
      }
    })
  }
}
