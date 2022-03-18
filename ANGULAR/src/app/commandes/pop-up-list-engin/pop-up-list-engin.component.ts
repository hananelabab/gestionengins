import { SelectionModel } from '@angular/cdk/collections';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';



export interface PeriodicElement {
  position: number;
  famille: string;
  codeEngin: string;
  type: string;
  capacite: string;
  compteur: string;
  matricule: string;
  dateAffectation: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position : 1 , famille: '1', codeEngin: 'Hydrogen', type: '1.0079', capacite: 'H',compteur: '1', matricule: 'Hydrogen', dateAffectation: '1.0079'},
  {position : 2 , famille: '2', codeEngin: 'Hydrogen', type: '1.0079', capacite: 'H',compteur: '1', matricule: 'Hydrogen', dateAffectation: '1.0079'},
  {position : 3 , famille: '2', codeEngin: 'Hydrogen', type: '1.0079', capacite: 'H',compteur: '1', matricule: 'Hydrogen', dateAffectation: '1.0079'},

];


@Component({
  selector: 'app-pop-up-list-engin',
  templateUrl: './pop-up-list-engin.component.html',
  styleUrls: ['./pop-up-list-engin.component.scss']
})


export class PopUpListEnginComponent implements OnInit {


  displayedColumns: string[] = ['select','famille', 'codeEngin', 'type', 'capacite', 'compteur', 'matricule', 'dateAffectation'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
  selection = new SelectionModel<PeriodicElement>(true, []);

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;

    const numRows = this.dataSource.data.length;

    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }

    this.selection.select(...this.dataSource.data);
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: PeriodicElement): string {

    console.log(row)
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.position + 1}`;
  }



  constructor(
    public dialogRef: MatDialogRef<PopUpListEnginComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,) {
      console.log(data)


  }

  ngOnInit(): void {

  }

  logSelection() {
    console.log("okay")
    console.log(this.selection.selected)

    this.selection.selected.forEach(s => console.log(s.famille));
  }

}
