import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { CuentasComponent } from './components/cuentas/cuentas.component';
import { MovimientosComponent } from './components/movimientos/movimientos.component';
import { HomeComponent } from './components/home/home.component';
  
const routes: Routes = [
  {path : '', component : HomeComponent},
  {path : 'cliente', component : ClienteComponent},
  {path : 'cuenta', component : CuentasComponent},
  {path : 'movimiento', component : MovimientosComponent}
];
  
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule  { }