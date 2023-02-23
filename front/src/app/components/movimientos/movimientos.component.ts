import { Component, OnInit } from '@angular/core';
import { CuentasService } from 'src/app/services/cuentas.service';
import { MovimientosService } from 'src/app/services/movimientos.service';

@Component({
  selector: 'app-movimientos',
  templateUrl: './movimientos.component.html',
  styleUrls: ['./movimientos.component.css']
})
export class MovimientosComponent implements OnInit{

  movimientos?: any
  searchText: any;

  constructor(
    private servMovi:MovimientosService,
    private servCuenta:CuentasService
    ){}

  ngOnInit(): void {
    
    this.servMovi.getAllMovimiento().subscribe(cli => {
      this.movimientos = cli
      console.log(this.movimientos)
      for(let mov of this.movimientos ){
        this.servCuenta.getCuentabyId(mov.cuentaId).subscribe(resp=>{
          mov.numeroCuenta=resp.numeroCuenta
          mov.tipoCuenta=resp.tipoCuenta
          mov.saldoInicial=resp.saldoInicial
          mov.estado=resp.estado
          console.log(mov)
        })
      }
    })
    
  }

}
