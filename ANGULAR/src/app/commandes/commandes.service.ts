import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommandesService {



  constructor(private http: HttpClient) { }

  listeDemandes(){
    return this.http.get(environment.url_prod+'/demandes/all' )
  }
  listeEnginsSortie(){
    return this.http.get(environment.url_n3man+'/listeEnginsSortie' )
  }
  listeEnginsEntree(){
    return this.http.get(environment.url_n3man+'/listeEnginsEntree' )
  }
  demande(numBCI){
    return this.http.get(environment.url_prod+'/demandes/'+numBCI )
  }
  engin(codeEngin){
    return this.http.get(environment.url_n3man+'/engin/'+codeEngin )
  }
  ajouterDemande(demande){
    return this.http.post(environment.url_prod+'/demandes/add',demande )

  }
}
