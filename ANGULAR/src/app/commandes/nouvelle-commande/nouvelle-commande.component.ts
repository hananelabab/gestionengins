import { CommandesService } from './../commandes.service';
import { PopUpListEnginComponent } from './../pop-up-list-engin/pop-up-list-engin.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { FormArray, FormControl, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-nouvelle-commande',
  templateUrl: './nouvelle-commande.component.html',
  styleUrls: ['./nouvelle-commande.component.scss']
})
export class NouvelleCommandeComponent implements OnInit {

  posts_value= []
  FGCommande:FormGroup
  FGEnginDemande:FormGroup
  FGEngins:FormGroup
  FGEnginCritere:FormGroup


  formFamille = new FormGroup({


      idFamille : new FormControl(),
      nomFamille:  new FormControl(),
      icon:  new FormControl(),
      quantite: new FormControl(),
      remarque: new FormControl(),

  })

  itemsFamilles: FormArray;
  itemsEngins: FormArray = null;



  animal: string;
  name: string;


  createFGEnginCritere() {
    this.FGEnginCritere = this.fb.group({
      engins: this.fb.array([])
    })
  }

  createEnginsArray(engin) {
    return this.fb.group({
      codeEngin: engin.codeEngin,
      typeEngin: engin.typeEngin,
      capacite: engin.capacite,
      compteur: engin.compteur,
      dateDernierAffectation: engin.dateDernierAffectation,
      famille: engin.famille,
      critere: new FormArray([])
    });
  }
  createCriteresArray(critere) {
    return this.fb.group({
      critere: critere.critere,
      etatEntree: critere.etatEntree,
      etatSortie: critere.etatSortie,
      idCritere: critere.idCritere,
      observationEntree: critere.observationEntree,
      observationSortie: critere.observationSortie,
    })
  }

  getEngins(form) {
    return form.controls.engins.controls;
  }

  getCriteres(form) {
    return form.controls.critere.controls;
  }

  addEngin(engin) {
    const control = <FormArray>this.FGEnginCritere.get('engins');
    control.push(this.createEnginsArray(engin));
  }
  addCriteres(critere,i) {
    const control = <FormArray>this.FGEnginCritere.get('engins')["controls"][i]?.get('critere');
    control?.push(this.createCriteresArray(critere));
    console.log(control);

  }



  openDialogEngins(): void {
    const dialogRef = this.dialog.open(PopUpListEnginComponent, {
      width: '1000px',
      data: {famille: this.itemsFamilles,engin: this.itemsFamilles},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }



  constructor(public commandesService :CommandesService,private fb: FormBuilder,public dialog: MatDialog,private modalService: NgbModal,public router: Router) {

    for (let i = 0; i < 35; i++) {
      this.posts_value.push(i);
    }
    this.FGCommande = new FormGroup({
      numBCI: new FormControl(),
      entite: new FormControl(),
      dateDemande: new FormControl(),
      dateSortie: new FormControl(),
      shift: new FormControl(),
      poste: new FormControl(),
      statut:new FormControl(),
      familleDemandee:new FormControl(),
      engins:new FormControl(),
    }
    )
    this.FGEnginDemande = new FormGroup({
      items: this.fb.array([])
    });
    this.FGEngins = new FormGroup({
      items: this.fb.array([])
    });


  }
  showObject(show){
      console.log(show)
  }



  ngOnInit(): void {
    this.createFGEnginCritere();



    if(this.router.url!='/commandes/nouvelle-commandes'){

    this.commandesService.demande(3).subscribe((data:any)=>{
          this.FGCommande.setValue(data)

          this.itemsFamilles = this.FGEnginDemande.get('items') as FormArray;

          data["familleDemandee"].forEach( famille => {
            this.itemsFamilles.push(this.fb.group({
              idFamille: famille.idFamille,
              nomFamille: famille.nomFamille,
              icon: famille.icon,
              quantite: famille.quantite,
              remarque: famille.remarque,
            }));
          });
          this.itemsEngins = this.FGEngins.get('items') as FormArray;

          let i = 0;
          data["engins"].forEach( engin => {
            console.log(engin)
            this.itemsEngins.push(this.fb.group({
              codeEngin: engin.codeEngin,
              typeEngin: engin.typeEngin,
              capacite: engin.capacite,
              compteur: engin.compteur,
              famille: engin.famille,
              dateDernierAffectation: engin.dateDernierAffectation,
              critere :this.fb.array(engin.critere)

            }));

            this.addEngin(engin);
            engin["critere"].forEach( critere => {
              this.addCriteres(critere,i)
            })
            i++
          });
          console.log(this.itemsEngins)


    })

  }

  }



  ajoutFamille(){
            this.itemsFamilles = this.FGEnginDemande.get('items') as FormArray;
            this.itemsFamilles.push(this.fb.group({
              nomFamille: this.formFamille.get('nomFamille').value,
              quantite: this.formFamille.get('quantite').value,
              remarque: this.formFamille.get('remarque').value,
            }));
  }
  ajouterDemande(){
    this.commandesService.ajouterDemande(this.FGCommande.value).subscribe((data:any)=>{


    })


  }



}
