import { FormBuilder, FormGroup } from '@angular/forms';
import { CommandesService } from './../commandes.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-commandes',
  templateUrl: './list-commandes.component.html',
  styleUrls: ['./list-commandes.component.scss']
})
export class ListCommandesComponent implements OnInit {
  title="List commandes ";
  status = "";
  listeDemandes: any;






  constructor(public router: Router,public commandesService: CommandesService,private fb:FormBuilder) {

    this.commandesService.listeDemandes().subscribe((data)=>{
      this.listeDemandes = data
    })

    if(this.router.url == '/commandes/list-commandes'){
      this.status = "";
    }
    else if(this.router.url == '/commandes/list-commandes-enregistree'){
      this.status = "Enregistrée";
    }
    else if(this.router.url == '/commandes/list-commandes-activee'){
      this.status = "Activée";
    }
    else if(this.router.url == '/commandes/list-commandes-termine'){
      this.status = "Terminé";
    }
    else if(this.router.url == '/commandes/list-commandes-executee'){
      this.status = "Executée";
    }
  }

  ngOnInit(): void {



  }

}
