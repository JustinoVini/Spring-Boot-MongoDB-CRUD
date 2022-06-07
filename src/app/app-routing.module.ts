import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//importando componentes
import { EmployeeListComponent } from './componentes/employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './componentes/update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './componentes/employee-details/employee-details.component';
import { CreateEmployeeComponent } from './componentes/create-employee/create-employee.component';

const routes: Routes = [
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'employees', component: EmployeeListComponent },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
  { path: 'details/:id', component: EmployeeDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
