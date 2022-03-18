import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TableCommandeComponent } from './childs/table-commande/table-commande.component';
import { ListCommandesComponent } from './list-commandes/list-commandes.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterModule, Routes } from '@angular/router';
import { NouvelleCommandeComponent } from './nouvelle-commande/nouvelle-commande.component';
import { PopUpListEnginComponent } from './pop-up-list-engin/pop-up-list-engin.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTableModule} from '@angular/material/table';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListEnginsComponent } from './list-engins/list-engins.component';
import { EnginComponent } from './engin/engin.component';

const routes: Routes = [
  { path: 'list-commandes', component: ListCommandesComponent },
  { path: 'list-commandes-enregistree', component: ListCommandesComponent },
  { path: 'list-engins-sortie', component: ListEnginsComponent },
  { path: 'list-engins-entree', component: ListEnginsComponent },
  { path: 'list-commandes-executee', component: ListCommandesComponent },
  { path: 'list-commandes', component: ListCommandesComponent },

  { path: 'engin', component: EnginComponent },


  { path: 'nouvelle-commandes', component: NouvelleCommandeComponent },
  { path: 'nouvelle-affectation', component: NouvelleCommandeComponent },
  { path: 'enregistrement-sortie-engin', component: NouvelleCommandeComponent },
  { path: 'enregistrement-entree-engin', component: NouvelleCommandeComponent }
]

@NgModule({
  declarations: [
    ListCommandesComponent,
    TableCommandeComponent,
    NouvelleCommandeComponent,
    PopUpListEnginComponent,
    ListEnginsComponent,
    EnginComponent

  ],
  imports: [
    CommonModule,
    NgbModule,
    MatDialogModule,
    MatTableModule,
    MatCheckboxModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)

  ],
  entryComponents: [
    PopUpListEnginComponent
  ],
  exports:[
    MatDialogModule

  ]
})
export class CommandesModule { }


